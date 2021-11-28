package edu.javavt19.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.javavt19.model.*;

public class PDFBuilder extends AbstractTextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        // get data model which is passed by the Spring container
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        paragraphFont.setSize(14);

        TypeOfModel typeOfModel = (TypeOfModel) model.get("typeOfModel");

        //просто переопределил для каждой модели свой способ отображения с огромной дублёжкой кода
        String PageName = "";
        PdfPTable modelTable = switch (typeOfModel){
            case AGENT_MODEL -> {
                PageName = "Agents";
                List<AgentModel>agentList = (List<AgentModel>) model.get("listModel");
                yield  getAgentTable(agentList);
            }
            case CONTRACT_MODEL -> {
                PageName = "Contracts";
                List<ContractModel>contractList = (List<ContractModel>) model.get("listModel");
                yield  getContractTable(contractList);
            }
            case BRANCH_OFFICE_MODEL -> {
                PageName = "Branch offices";
                List<BranchOfficeModel>branchOfficeList = (List<BranchOfficeModel>) model.get("listModel");
                yield getBranchOfficeTable(branchOfficeList);
            }
            case INSURANCE_TYPE_MODEL -> {
                PageName = "Types of insurance";
                List<InsuranceTypeModel>insuranceTypeList = (List<InsuranceTypeModel>) model.get("listModel");
                yield getInsuranceTypeTable(insuranceTypeList);
            }
        };

        Paragraph brandParagraph = new Paragraph(PageName,paragraphFont);
        brandParagraph.setAlignment(Element.ALIGN_CENTER);
        doc.add(brandParagraph);
        doc.add(modelTable);

    }

    private PdfPTable getInsuranceTypeTable(List<InsuranceTypeModel> insuranceTypeList)throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 2.5f, 1.2f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Agent percentage", font));
        table.addCell(cell);

        // write table row data
        for (InsuranceTypeModel insuranceTypeModel : insuranceTypeList) {
            table.addCell("" + insuranceTypeModel.getId());
            table.addCell(insuranceTypeModel.getName());
            table.addCell(insuranceTypeModel.getAgent_percentage().toString());
        }
        return table;
    }

    private PdfPTable getBranchOfficeTable(List<BranchOfficeModel> branchOfficeList)throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 2.5f, 3.5f, 1.2f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Phone number", font));
        table.addCell(cell);

        // write table row data
        for (BranchOfficeModel officeModel : branchOfficeList) {
            table.addCell("" + officeModel.getId());
            table.addCell(officeModel.getName());
            table.addCell(officeModel.getAddress());
            table.addCell(officeModel.getPhoneNumber());
        }
        return table;
    }

    private PdfPTable getContractTable(List<ContractModel> contractList) throws DocumentException {
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 1.0f, 1.2f, 2.0f, 1.0f, 2.5f, 2.5f });
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Sum insured", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Insured type", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Traffic rate", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Agent surname", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Branch office name", font));
        table.addCell(cell);

        // write table row data
        for (ContractModel contractModel : contractList) {
            table.addCell("" + contractModel.getId());
            table.addCell(contractModel.getDate().toString());
            table.addCell("" + contractModel.getSum_insured());
            table.addCell(contractModel.getInsurance_type_model().getName());
            table.addCell(contractModel.getTariff_rate().toString());
            table.addCell(contractModel.getAgent().getSecondName());
            table.addCell(contractModel.getAgent().getOfficeModel().getName());
        }
        return table;
    }

    private PdfPTable getAgentTable(List<AgentModel> agentList) throws DocumentException {
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{0.4f, 2.0f, 2.5f, 2.0f, 4.0f, 2.5f, 3.5f });
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA, "ISO-8859-5");
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        // write table header
        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("First name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Second name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Patronymic", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Phone number", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Branch office name", font));
        table.addCell(cell);

        // write table row data
        for (AgentModel agentModel : agentList) {
            table.addCell("" + agentModel.getId());
            table.addCell(agentModel.getFirstName());
            table.addCell(agentModel.getSecondName());
            table.addCell(agentModel.getPatronymic());
            table.addCell(agentModel.getAddress());
            table.addCell(agentModel.getPhoneNumber());
            table.addCell(agentModel.getOfficeModel().getName());
        }
        return table;
    }
}