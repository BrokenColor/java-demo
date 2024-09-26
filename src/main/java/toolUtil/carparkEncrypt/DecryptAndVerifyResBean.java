package toolUtil.carparkEncrypt;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DecryptAndVerifyResBean extends Result {

    private static final long serialVersionUID = 2252573517148099687L;

    private String plain;

    private boolean verify;

}
