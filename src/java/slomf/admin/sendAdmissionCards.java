package slomf.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import slomf.api.Database.Constants;
import slomf.api.Mail.sendMail;
import slomf.api.reportGeneration.MergePDF;
import slomf.api.reportGeneration.PdfFill;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import slomf.api.Database.FTPTransfer;
import slomf.registration.School;
import slomf.registration.Student;
import slomf.registration.dao.SchoolDA;
import slomf.registration.dao.StudentDA;

public class sendAdmissionCards {

    static final String admissionCardNames = Constants.LOCATION + "ReportTemplates\\AdmissionCard";

    public static void sendtoPrivate() {
        ArrayList<Student> list = StudentDA.getAllPrivateStudents();
        Student s;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            slomf.admin.Log.addLog(s.getName());
            PdfFill a = new PdfFill(admissionCardNames + ".pdf");
            a.setField("Medium", s.getMedium());
            a.setField("Name", s.getName());
            a.setField("Index", s.getIndex() + "");
            a.setField("Exam", s.getAssigned_centre());
            a.save(admissionCardNames + s.getIndex() + ".pdf");
            String message = "Dear " + s.getName() + ",\n"
                    + "Please find attached the admission card for SLMC 2014.\n\n"
                    + "Sri Lanka Olympiad Mathematics Foundation\n"
                    + "University of Colombo";
            String filepath = admissionCardNames + s.getIndex() + ".pdf";
            String filename = "AdmissionCard.pdf";

            sendMail.sendMailWithAttachment(s.getEmail(), "Admission Card for SLMC 2014", message,
                    filepath, filename);
            File file = new File(filepath);
            file.delete();
        }
    }

    public static void sendtoSchool() {
        ArrayList<School> schoolList = SchoolDA.getAllSchools();
        ArrayList<Student> list;
        for (int j = 0; j < schoolList.size(); j++) {
            list = schoolList.get(j).getStudentList();
            ArrayList<String> files = new ArrayList<String>();
            for (Student s : list) {
                slomf.admin.Log.addLog(s.getName());
                PdfFill a = new PdfFill(admissionCardNames + ".pdf");
                a.setField("Medium", s.getMedium());
                a.setField("Name", s.getName());
                a.setField("Index", s.getIndex() + "");
                a.setField("Exam", s.getAssigned_centre());
                a.save(admissionCardNames + s.getIndex() + ".pdf");
                files.add(admissionCardNames + s.getIndex() + ".pdf");
            }
            new MergePDF().merge(files, admissionCardNames + schoolList.get(j).getName() + ".pdf");
            for (Student s : list) {
                File file = new File(admissionCardNames + s.getIndex() + ".pdf");
                file.delete();
            }

            String message = "Dear " + schoolList.get(j).getContactname() + ",\n"
                    + "Please find attached the admission card for SLMC 2014.\n\n"
                    + "Sri Lanka Olympiad Mathematics Foundation\n"
                    + "University of Colombo";
            String filepath = admissionCardNames + schoolList.get(j).getName() + ".pdf";
            String filename = "AdmissionCard.pdf";
            sendMail.sendMailWithAttachment(schoolList.get(j).getEmail(), "Admission Card for SLMC 2014", message,
                    filepath, filename);
            File file = new File(filepath);
            file.delete();


        }
    }

    public static void send2School(ArrayList<School> schoolList) {
        FTPClient ftp = FTPTransfer.setup(true);
        InputStream inStream;
        try {
            inStream = ftp.retrieveFileStream("AdmissionCard.pdf");
            PdfFill a = new PdfFill(inStream);
            PDField fieldMedium = a.getField("Medium");
            PDField fieldName = a.getField("Name");
            PDField fieldIndex = a.getField("Index");
            PDField fieldExam = a.getField("Exam");
            ArrayList<Student> list;
            for (int j = 0; j < schoolList.size(); j++) {
                list = schoolList.get(j).getStudentList();
                ByteArrayOutputStream outStream;
                MergePDF mergePDF = new MergePDF();
                for (Student s : list) {
                    slomf.admin.Log.addLog(s.getName());
                    outStream = new ByteArrayOutputStream();
                    fieldMedium.setValue(s.getMedium());
                    fieldName.setValue(s.getName());
                    fieldIndex.setValue(s.getIndex() + "");
                    fieldExam.setValue(s.getAssigned_centre());
                    a.saveToOutputStream(outStream);
                    mergePDF.addSource(new ByteArrayInputStream(outStream.toByteArray()));
                }
                outStream= new ByteArrayOutputStream();
                mergePDF.merge(outStream);
                String message = "Dear " + schoolList.get(j).getContactname() + ",\n"
                        + "Please find attached the admission card for SLMC 2014.\n\n"
                        + "Sri Lanka Olympiad Mathematics Foundation\n"
                        + "University of Colombo";
                String filename = "AdmissionCard.pdf";
                sendMail.sendMailWithAttachment(schoolList.get(j).getEmail(), "Admission Card for SLMC 2014", message,
                        outStream, filename);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> list = StudentDA.getAllPrivateStudents();
        ArrayList<Student> listnew = new ArrayList<Student>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals("i.d.fernando@ieee.org")
                    || list.get(i).getEmail().equals("isurufdo@yahoo.com")) {
                listnew.add(list.get(i));
            }
        }
        send2Private(listnew);
    }

    public static void send2Private(ArrayList<Student> list) {
        FTPClient ftp = FTPTransfer.setup(true);
        InputStream inStream;
        try {
            inStream = ftp.retrieveFileStream("AdmissionCard.pdf");
            PdfFill a = new PdfFill(inStream);
            PDField fieldMedium = a.getField("Medium");
            PDField fieldName = a.getField("Name");
            PDField fieldIndex = a.getField("Index");
            PDField fieldExam = a.getField("Exam");
            Student s;
            for (int i = 0; i < list.size(); i++) {
                s = list.get(i);
                slomf.admin.Log.addLog(s.getName());
                fieldMedium.setValue(s.getMedium());
                fieldName.setValue(s.getName());
                fieldIndex.setValue(s.getIndex() + "");
                fieldExam.setValue(s.getAssigned_centre());
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                a.saveToOutputStream(outStream);
                String message = "Dear " + s.getName() + ",\n"
                        + "Please find attached the admission card for SLMC 2014.\n\n"
                        + "Sri Lanka Olympiad Mathematics Foundation\n"
                        + "University of Colombo";
                String filename = "AdmissionCard.pdf";

                sendMail.sendMailWithAttachment(s.getEmail(), "Admission Card for SLMC 2014", message,
                        outStream, filename);
            }
        } catch (IOException ex) {
        }
    }
}
