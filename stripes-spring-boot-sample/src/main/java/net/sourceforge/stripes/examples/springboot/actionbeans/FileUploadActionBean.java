package net.sourceforge.stripes.examples.springboot.actionbeans;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class FileUploadActionBean implements ActionBean {

    private ActionBeanContext context;

    private FileBean attachment;
    private String fileName;

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    @Override
    public void setContext( final ActionBeanContext context ) {
        this.context = context;
    }

    public FileBean getAttachment() {
        return attachment;
    }

    public void setAttachment( FileBean attachment ) {
        System.out.println( "> " + attachment );
        this.attachment = attachment;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @DefaultHandler
    public Resolution fileUpload() {
        System.out.println( "** " + attachment );
        fileName = attachment.getFileName();
        return new ForwardResolution( "/file-upload.jsp" );
    }

}
