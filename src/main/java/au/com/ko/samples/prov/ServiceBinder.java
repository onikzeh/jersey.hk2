package au.com.ko.samples.prov;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * HK2 binder to configure the server side bindings.
 */
public class ServiceBinder  extends AbstractBinder {
	@Override
	protected void configure() {
		bindFactory(SignerFactory.class).to(Signer.class).in(Singleton.class);
	}
}
