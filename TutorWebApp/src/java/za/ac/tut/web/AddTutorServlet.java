/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.model.bl.TutorFacadeLocal;
import za.ac.tut.model.enties.Image;
import za.ac.tut.model.enties.Tutor;

/**
 *
 * @author ltham
 */
@MultipartConfig
public class AddTutorServlet extends HttpServlet {

    @EJB
    TutorFacadeLocal tfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long tut_number= Long.parseLong(request.getParameter("tut_number"));
        String tut_name= request.getParameter("tut_name");
        String tut_gender = request.getParameter("tut_gender");
        Integer tut_age= Integer.parseInt(request.getParameter("tut_age"));
        Collection<Part> tut_parts = request.getParts();
        List<byte[]> images = new ArrayList<>();
        
        for(Part part:tut_parts){
            if(part.getContentType() !=null){
                String image_name = part.getSubmittedFileName();
                InputStream part_stream = part.getInputStream();
                byte[] image_blob = getPartBlob(part_stream);
                images.add(new Image(image_name, image_blob));
            }
        }
        String[] tut_subjects = request.getParameterValues("tut_subjects");
        List<String> subjects = new ArrayList<>();
        for(int i = 0; i < tut_subjects.length;i++){
            subjects.add(tut_subjects[1]);
        }
        
        Tutor tutor = new Tutor(tut_number, tut_name, tut_age, tut_gender, subjects, images);
    }

    private byte[] getPartBlob(InputStream part_stream) {
        byte[] image_blob = null;
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int value;
        
        try {
            while((value=part_stream.read(buffer))!=-1){
                baos.write(buffer, 0, value);
            }
        } catch (IOException ex) {
            Logger.getLogger(AddTutorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image_blob;
    }
}
