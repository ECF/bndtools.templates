package $basePackageName$;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import $api_package$.ArithmeticTools;

/**
 * OSGi Service Component Annotation
 * 
 * The service.exported.interfaces property is defined as a standard property in the  
 * <a href="https://docs.osgi.org/specification/osgi.cmpn/8.0.0/service.remoteservices.html#i1710847">OSGi Remote Services Specification</a>
 *
 * Used with bndtools, this Component annotation results in the compile-time creation of 
 * file: OSGI-INF/myproject.impl.ArithmeticToolsComponent.xml and combined with
 * Declarative Services (SCR) and an impl of OSGi Remote Service Admin (RS/RSA) at runtime 
 * this service will be registered by SCR and exported by RSA service impls.
 */
@Component(immediate = true, property = { "service.exported.interfaces=*" } )
public class ArithmeticToolsComponent implements ArithmeticTools {

	private static final Logger logger = LoggerFactory.getLogger(ArithmeticToolsComponent.class);
	
	@Override
	public double add(double x, double y) {
		logger.debug("adding x="+ Double.toString(x) + ";y=" + Double.toString(y));
		double result =  x + y;
		logger.debug("add result="+ Double.toString(result));
		return result;
	}

	@Override
	public double multiply(double x, double y) {
		logger.debug("multiplying x="+ Double.toString(x) + ";y=" + Double.toString(y));
		double result = x * y;
		logger.debug("multiply result="+ Double.toString(result));
		return result;
	}

}
