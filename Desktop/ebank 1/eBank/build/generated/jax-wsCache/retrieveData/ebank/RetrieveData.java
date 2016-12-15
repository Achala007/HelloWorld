
package ebank;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "retrieveData", targetNamespace = "http://eBank/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RetrieveData {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveCustomerList", targetNamespace = "http://eBank/", className = "ebank.RetrieveCustomerList")
    @ResponseWrapper(localName = "retrieveCustomerListResponse", targetNamespace = "http://eBank/", className = "ebank.RetrieveCustomerListResponse")
    @Action(input = "http://eBank/retrieveData/retrieveCustomerListRequest", output = "http://eBank/retrieveData/retrieveCustomerListResponse")
    public List<String> retrieveCustomerList();

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveEmployeeList", targetNamespace = "http://eBank/", className = "ebank.RetrieveEmployeeList")
    @ResponseWrapper(localName = "retrieveEmployeeListResponse", targetNamespace = "http://eBank/", className = "ebank.RetrieveEmployeeListResponse")
    @Action(input = "http://eBank/retrieveData/retrieveEmployeeListRequest", output = "http://eBank/retrieveData/retrieveEmployeeListResponse")
    public List<String> retrieveEmployeeList();

}
