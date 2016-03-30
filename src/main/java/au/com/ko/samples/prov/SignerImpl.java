package au.com.ko.samples.prov;

/**
 * Implementation of {@Code Signer}.
 */
public class SignerImpl implements Signer {

	private String signature;

	public SignerImpl(String signature) {
		this.signature = signature;
	}

	@Override
	public String sign(String dataToSign) {
		return dataToSign + signature;
	}
}
