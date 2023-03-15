package tourGuide.helper;

/**
 * InternalTestHelper class is used to set the number of internal users for performance testing and testing
 */
public class InternalTestHelper {

	// Set this default up to 100,000 for testing
	private static int internalUserNumber = 100;
	
	public static void setInternalUserNumber(int internalUserNumber) {
		InternalTestHelper.internalUserNumber = internalUserNumber;
	}
	
	public static int getInternalUserNumber() {
		return internalUserNumber;
	}
}
