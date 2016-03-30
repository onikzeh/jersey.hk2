package au.com.ko.samples.prov;

import org.glassfish.hk2.api.Factory;

import javax.inject.Singleton;

/**
 * HK2 factory for Directory instance.
 */
@Singleton
public class SignerFactory implements Factory<Signer> {

	@Override
	public Signer provide() {
		return new SignerImpl(" is signed!");
	}

	@Override
	public void dispose(Signer signer) {
		// We can do a cleanup here
	}
}