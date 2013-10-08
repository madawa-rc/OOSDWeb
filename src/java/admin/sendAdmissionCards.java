/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import Mail.sendMail;
import ReportGeneration.MergePDF;
import ReportGeneration.PdfFill;
import java.util.ArrayList;
import slmo.registration.School;
import slmo.registration.Student;
import slmo.registration.dao.SchoolDA;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author New
 */
public class sendAdmissionCards {

    static final String admissionCardNames = "C:\\Users\\New\\Documents\\NetBeansProjects\\OOSDWeb\\AdmissionCard";

    public static void main(String[] args) {
        new sendAdmissionCards().sendtoPrivate();
    }

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
            sendMail.sendMailWithAttachment(s.getEmail(), "Admission Card for SLMC 2014", "Dear Applicant,\n"
                    + "Please find attached the admission card for SLMC 2014.\n\n"
                    + "Sri Lanka Olympiad Mathematics Foundation\n"
                    + "University of Colombo", admissionCardNames + s.getIndex() + ".pdf", "AdmissionCard.pdf");
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
            sendMail.sendMailWithAttachment(schoolList.get(j).getEmail(), "Admission Card for SLMC 2014", "Dear Applicant,\n"
                    + "Please find attached the admission card for SLMC 2014.\n\n"
                    + "Sri Lanka Olympiad Mathematics Foundation\n"
                    + "University of Colombo", admissionCardNames + schoolList.get(j).getName() + ".pdf", "AdmissionCard.pdf");



        }
    }
}
