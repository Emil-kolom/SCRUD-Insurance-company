
package edu.javavt19.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.javavt19.model.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBuilder extends AbstractPOIExcelView {

    Font font;
    CellStyle headerStyle;

    @Override
    protected XSSFWorkbook createWorkbook() {
        return new XSSFWorkbook();
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, XSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        font = workbook.createFont();
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        font.setFontName("Helvetica");

        headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        // get data model which is passed by the Spring container
        // получаю из контейнера лист базовых моделей
        TypeOfModel typeOfModel = (TypeOfModel) model.get("typeOfModel");

        //просто переопределил для каждой модели свой способ отображения с огромной дублёжкой кода
        switch (typeOfModel){
            case AGENT_MODEL -> {
                List<AgentModel>agentList = (List<AgentModel>) model.get("listModel");
                generateAgentSheet(workbook,agentList);
            }
            case CONTRACT_MODEL -> {
                List<ContractModel>contractList = (List<ContractModel>) model.get("listModel");
                generateContractSheet(workbook,contractList);
            }
            case BRANCH_OFFICE_MODEL -> {
                List<BranchOfficeModel>branchOfficeList = (List<BranchOfficeModel>) model.get("listModel");
                generateBranchOfficeSheet(workbook,branchOfficeList);
            }
            case INSURANCE_TYPE_MODEL -> {
                List<InsuranceTypeModel>insuranceTypeList = (List<InsuranceTypeModel>) model.get("listModel");
                generateInsuranceTypeSheet(workbook,insuranceTypeList);
            }
        }
    }

    private void generateInsuranceTypeSheet(XSSFWorkbook workbook, List<InsuranceTypeModel> insuranceTypeList) {

        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Insurance type");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,10000);
        sheet.setColumnWidth(2,2000);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("Insurance type");
        headerRow.createCell(2).setCellValue("Agent percentage");

        for (int i = 0; i <= 2; ++i){
            headerRow.getCell(i).setCellStyle(headerStyle);
        }

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // create data rows
        int rowCount = 1;
        for (InsuranceTypeModel insuranceType : insuranceTypeList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(insuranceType.getId());
            row.createCell(1).setCellValue(insuranceType.getName());
            row.createCell(2).setCellValue(insuranceType.getAgent_percentage());
            for (int i = 0; i <= 2; ++i){
                row.getCell(i).setCellStyle(rowCellStyle);
            }
        }
    }

    private void generateBranchOfficeSheet(XSSFWorkbook workbook, List<BranchOfficeModel> branchOfficeList) {
        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Branch office");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,8000);
        sheet.setColumnWidth(2,10000);
        sheet.setColumnWidth(3,4000);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Address");
        headerRow.createCell(3).setCellValue("Phone number");

        for (int i = 0; i <= 3; ++i){
            headerRow.getCell(i).setCellStyle(headerStyle);
        }

        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // create data rows
        int rowCount = 1;
        for (BranchOfficeModel branchOfficeModel : branchOfficeList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(branchOfficeModel.getId());
            row.createCell(1).setCellValue(branchOfficeModel.getName());
            row.createCell(2).setCellValue(branchOfficeModel.getAddress());
            row.createCell(3).setCellValue(branchOfficeModel.getPhoneNumber());
            for (int i = 0; i <= 3; ++i){
                row.getCell(i).setCellStyle(rowCellStyle);
            }
        }
    }

    private void generateAgentSheet(XSSFWorkbook workbook, List<AgentModel> agentList) {
        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Agent");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,8000);
        sheet.setColumnWidth(2,8000);
        sheet.setColumnWidth(3,8000);
        sheet.setColumnWidth(4,10000);
        sheet.setColumnWidth(5,4000);
        sheet.setColumnWidth(6,8000);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("First name");
        headerRow.createCell(2).setCellValue("Second Name");
        headerRow.createCell(3).setCellValue("Patronymic");
        headerRow.createCell(4).setCellValue("Address");
        headerRow.createCell(5).setCellValue("Phone number");
        headerRow.createCell(6).setCellValue("Branch office name");

        for (int i = 0; i <= 6; ++i){
            headerRow.getCell(i).setCellStyle(headerStyle);
        }
        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // create data rows
        int rowCount = 1;
        for (AgentModel agentModel : agentList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(agentModel.getId());
            row.createCell(1).setCellValue(agentModel.getFirstName());
            row.createCell(2).setCellValue(agentModel.getSecondName());
            row.createCell(3).setCellValue(agentModel.getPatronymic());
            row.createCell(4).setCellValue(agentModel.getAddress());
            row.createCell(5).setCellValue(agentModel.getPhoneNumber());
            row.createCell(6).setCellValue(agentModel.getOfficeModel().getName());

            for (int i = 0; i <= 6; ++i){
                row.getCell(i).setCellStyle(rowCellStyle);
            }
        }
    }

    private void generateContractSheet(XSSFWorkbook workbook, List<ContractModel> contractList){
        // create a new Excel sheet
        Sheet sheet = workbook.createSheet("Agent");
        sheet.setColumnWidth(0,2000);
        sheet.setColumnWidth(1,2500);
        sheet.setColumnWidth(2,2500);
        sheet.setColumnWidth(3,8000);
        sheet.setColumnWidth(4,2500);
        sheet.setColumnWidth(5,10000);
        sheet.setColumnWidth(6,10000);

        // create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("Date");
        headerRow.createCell(2).setCellValue("Sum insured");
        headerRow.createCell(3).setCellValue("Insured type");
        headerRow.createCell(4).setCellValue("Tariff rate");
        headerRow.createCell(5).setCellValue("Agent surname");
        headerRow.createCell(6).setCellValue("Branch office name");

        for (int i = 0; i <= 6; ++i){
            headerRow.getCell(i).setCellStyle(headerStyle);
        }
        CellStyle rowCellStyle = workbook.createCellStyle();
        rowCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // create data rows
        int rowCount = 1;
        for (ContractModel contractModel : contractList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(contractModel.getId());
            row.createCell(1).setCellValue(contractModel.getDate());
            row.createCell(2).setCellValue(contractModel.getSum_insured());
            row.createCell(3).setCellValue(contractModel.getInsurance_type_model().getName());
            row.createCell(4).setCellValue(contractModel.getTariff_rate());
            row.createCell(5).setCellValue(contractModel.getAgent().getSecondName());
            row.createCell(6).setCellValue(contractModel.getAgent().getOfficeModel().getName());

            for (int i = 0; i <= 6; ++i){
                row.getCell(i).setCellStyle(rowCellStyle);
            }
        }
    }
}