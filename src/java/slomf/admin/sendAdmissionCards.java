package slomf.admin;

import slomf.api.Database.Constants;
import slomf.api.Mail.sendMail;
import slomf.api.reportGeneration.MergePDF;
import slomf.api.reportGeneration.PdfFill;
import java.io.File;
import java.util.ArrayList;
import slomf.registration.School;
import slomf.registration.Student;
import slomf.registration.dao.SchoolDA;
import slomf.registration.dao.StudentDA;

public class sendAdmissionCards {

    static final String admissionCardNames = Constants.LOCATION + "Reports\\AdmissionCard";

    public static void sendtoPrivate() {
        ArrayList<Student> list = StudentDA.getAllPrivateStudents();
        Student s;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            System.out.println(s.getName());
            PdfFill a = new PdfFill(admissionCardNames + ".pdf");
            a.setField("Medium", s.getMedium());
            a.setField("Name", s.getName());
            a.setField("Index", s.getIndex() + "");
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
                System.out.println(s.getName());
                PdfFill a = new PdfFill(admissionCardNames + ".pdf");
                a.setField("Medium", s.getMedium());
                a.setField("Name", s.getName());
                a.setField("Index", s.getIndex() + "");
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
}
