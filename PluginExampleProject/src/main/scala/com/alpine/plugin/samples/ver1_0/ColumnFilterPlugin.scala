package com.alpine.plugin.samples.ver1_0

import com.alpine.plugin.core._
import com.alpine.plugin.core.datasource.OperatorDataSourceManager
import com.alpine.plugin.core.dialog.{ColumnFilter, OperatorDialog}
import com.alpine.plugin.core.io._
import com.alpine.plugin.core.spark.templates.{SparkDataFrameGUINode, SparkDataFrameJob, SparkDataFrameRuntime}
import com.alpine.plugin.core.spark.utils.SparkUtils
import org.apache.spark.sql.DataFrame

class ColumnFilterSignature extends OperatorSignature[
  ColumnFilterGUINode,
  ColumnFilterRuntime] {
  def getMetadata(): OperatorMetadata = {
    new OperatorMetadata(
      name = "Example ColumnFilter (Spark)",
      category = "Transformation",
      author = "Egor Pakhomov",
      version = 1,
      helpURL = "",
      iconNamePrefix = ""
    )
  }
}

object ColumnFilterConstants {
  val COLUMNS_TO_KEEP_KEY = "columnsToKeep"
}

class ColumnFilterGUINode extends
SparkDataFrameGUINode[ColumnFilterJob] {
  override def onPlacement(operatorDialog: OperatorDialog,
                           operatorDataSourceManager: OperatorDataSourceManager,
                           operatorSchemaManager: OperatorSchemaManager): Unit = {

    operatorDialog.addTabularDatasetColumnCheckboxes(
      ColumnFilterConstants.COLUMNS_TO_KEEP_KEY,
      "Columns to keep",
      ColumnFilter.All,
      "main"
    )

    super.onPlacement(operatorDialog, operatorDataSourceManager, operatorSchemaManager)
  }

  override def defineOutputSchemaColumns(inputSchema: TabularSchema,
                                         parameters: OperatorParameters): Seq[ColumnDef] = {
    val columnsToKeep =
      parameters.getTabularDatasetSelectedColumns(ColumnFilterConstants.COLUMNS_TO_KEEP_KEY)._2.toSet
    inputSchema.getDefinedColumns().filter(colDef => columnsToKeep.contains(colDef.columnName))
  }

}

class ColumnFilterRuntime extends SparkDataFrameRuntime[ColumnFilterJob] {}

class ColumnFilterJob extends SparkDataFrameJob {
  override def transform(parameters: OperatorParameters,
                         dataFrame: DataFrame,
                         sparkUtils: SparkUtils,
                         listener: OperatorListener): DataFrame = {
    val columnNamesToKeep = parameters
      .getTabularDatasetSelectedColumns(ColumnFilterConstants.COLUMNS_TO_KEEP_KEY)._2
    val columnsToKeep = columnNamesToKeep.map(dataFrame.col)
    dataFrame.select(columnsToKeep: _*)
  }
}
