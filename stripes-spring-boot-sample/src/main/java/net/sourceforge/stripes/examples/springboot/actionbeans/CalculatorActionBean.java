package net.sourceforge.stripes.examples.springboot.actionbeans;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;


/**
 * A very simple calculator action.
 *
 * @author Tim Fennell
 */
@UrlBinding("/stripes/sb/calc")
public class CalculatorActionBean implements ActionBean {

    private ActionBeanContext context;
    @Validate( required = true )
    private double numberOne;
    @Validate( required = true )
    private double numberTwo;
    private double result;

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    @Override
    public void setContext( final ActionBeanContext context ) {
        this.context = context;
    }

    public double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne( final double numberOne ) {
        this.numberOne = numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo( final double numberTwo ) {
        this.numberTwo = numberTwo;
    }

    public double getResult() {
        return result;
    }

    public void setResult( final double result ) {
        this.result = result;
    }

    @ValidationMethod( on = "division" )
    public void avoidDivideByZero( final ValidationErrors errors ) {
        if( this.numberTwo == 0 ) {
            errors.add( "numberTwo", new SimpleError( "Dividing by zero is not allowed." ) );
        }
    }

    @DefaultHandler
    public Resolution addition() {
        result = getNumberOne() + getNumberTwo();
        return new ForwardResolution( "/index.jsp" );
    }

    public Resolution division() {
        result = numberOne / numberTwo;
        return new ForwardResolution( "/index.jsp" );
    }

}
