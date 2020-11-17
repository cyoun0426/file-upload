package edu.nd.mlab.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        ServletFileUpload upload = new ServletFileUpload();

        try{
            FileItemIterator iter = upload.getItemIterator(request);

            while (iter.hasNext()) {
                FileItemStream item = iter.next();

                String name = item.getName();
                System.out.println("get file name: "+ name + ", type:" + item.getContentType());
                InputStream stream = item.openStream();


                FileOutputStream fileOut = new FileOutputStream(new File("C:/Users/Christina/Desktop/"+name));
                
                // Process the input stream
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int len;
                byte[] buffer = new byte[8192];
                while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
//                    out.write(buffer, 0, len);
                    fileOut.write(buffer, 0, len);
                }
//                System.out.println("get file size: " + fileOut.);
//                int maxFileSize = 10*(1024*1024); //10 megs max 
//                if (out.size() > maxFileSize) { 
//                    throw new RuntimeException("File is > than " + maxFileSize);
//                }
                fileOut.flush();
                fileOut.close();
                
                //check the file type
                //check file size
                
                
                response.getWriter().write("success");
            }
        }
        catch(Exception e){
        	e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
