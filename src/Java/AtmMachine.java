package Java;
public class AtmMachine {

	@SuppressWarnings("serial")
	public static class AtmAccessError extends Exception {
		public AtmAccessError(String message) {
			super(message);
		}
	}

	public interface AsyncResult<DATA> {

		/**
		 * @param data !null on success
		 * @param error !null on error
		 */
		void onResult(DATA data, Exception error);
	}

	// Singleton -- prefer Dependency Injection
	public static final class Network {
		private static final Network SELF = new Network();

		public static final Network get() {
			return SELF;
		}

		public void execute(Runnable runnable) {
			// Or some better platform specific asynchronous mechanism
			// Or minimally a Pooled Executor
			Thread t = new Thread(runnable);
			t.start();
		}

		/**
		 * I/O Blocking -- Call from Worker Thread<br>
		 * Use: {@link #execute(Runnable)}
		 * 
		 * @return true if access verified
		 * @throws Exception - prefer something more descriptive like NetworkException, etc.
		 */
		public boolean authenticate(String cardNumber, int pinNumber) throws Exception {
			Thread.sleep(1000); // simulate network
			return true; // connect to server and authenticate
		}

		/**
		 * I/O Blocking -- Call from Worker Thread<br>
		 * Use: {@link #execute(Runnable)}
		 * 
		 * @param cardNumber
		 * @param amount
		 * @return current balance after transaction
		 * @throws Exception - prefer something more descriptive like NetworkException, etc.
		 */
		public float deposit(String cardNumber, float amount) throws Exception {
			Thread.sleep(1000); // simulate network
			return amount; // connect to server and perform transaction
		}

		/**
		 * I/O Blocking -- Call from Worker Thread<br>
		 * Use: {@link #execute(Runnable)}
		 * 
		 * @param cardNumber
		 * @param amount
		 * @return current balance after transaction
		 * @throws Exception - prefer something more descriptive like NetworkException, etc.
		 */
		public float withdraw(String cardNumber, float amount) throws Exception {
			Thread.sleep(1000); // simulate network
			return amount; // connect to server and perform transaction
		}
	}

	public static final class AtmSession {
		private String mCardNumber;

		private AtmSession(String cardNumber) {
			mCardNumber = cardNumber;
		}

		/**
		 * Transaction is rolled back if error occurs.<br>
		 * Call from Worker Thread
		 * 
		 * @param amount to deposit
		 * @param result containing the new balance or error
		 */
		public void deposit(float amount, AsyncResult<Float> result) {
			try {
				float newAmount = Network.get().deposit(mCardNumber, amount);
				result.onResult(newAmount, null);
			} catch (Exception e) {
				result.onResult(null, e);
			}
		}

		/**
		 * Transaction is rolled back if error occurs.<br>
		 * Call from Worker Thread
		 * 
		 * @param amount to withdraw
		 * @param result containing the new balance or error
		 */
		public void withdraw(float amount, AsyncResult<Float> result) {
			try {
				float newAmount = Network.get().withdraw(mCardNumber, amount);
				result.onResult(newAmount, null);
			} catch (Exception e) {
				result.onResult(null, e);
			}
		}
	}

	/**
	 * Authenticate the user and begin the session
	 */
	public void insertCard(final String cardNumber, final int pinNumber, AsyncResult<AtmSession> result) {
		Network.get().execute(() -> {
			try {
				if (Network.get().authenticate(cardNumber, pinNumber)) {
					result.onResult(new AtmSession(cardNumber), null);
				} else {
					throw new AtmAccessError("Access Denied - Invalid Pin#");
				}
			} catch (Exception e) {
				result.onResult(null, e);
			}
		});
	}

	public static final class AtmUserInterface {
		private AtmMachine mAtm;

		public AtmUserInterface() {
			mAtm = new AtmMachine();
		}

		public void showLoginScreen() {
			System.out.print("Login Screen: ");
			String card = "4000867530919618"; // FIXME: obtained from UI
			int pin = 12345; // FIXME: obtained from UI -- same as match luggage

			showLoadingScreen("Login");
			mAtm.insertCard(card, pin, (access, err) -> {
				try {
					if (err != null) {
						throw err;
					}
					System.out.println("Login Success");
					showAccessScreen(access);
				} catch (Exception e) {
					showErrorScreen(e);
				}
			});
		}

		private void showLoadingScreen(String message) {
			// hide other screens
			// TODO show loading ui
			System.out.print("...Please Wait: " + message + "...");
		}

		private void showAccessScreen(AtmSession access) {
			// hide other screens
			// TODO show access ui
			System.out.println("Access Screen");

			// Simulate UI actions
			showLoadingScreen("Depositing");
			access.deposit(1000.0f, (amount, err) -> {
				try {
					if (err != null) {
						throw err;
					}
					// TODO confirm transaction to user
					System.out.println("Deposited: " + amount);
					// TODO reset access screen UI
					System.out.println("Back to Access Screen");
				} catch (Exception e) {
					showErrorScreen(e);
				}
			});

			// Simulate UI actions
			showLoadingScreen("Withdrawing");
			access.withdraw(1000.0f, (amount, err) -> {
				try {
					if (err != null) {
						throw err;
					}
					// TODO confirm transaction to user
					System.out.println("Withdrew: " + amount);
					// TODO reset access screen UI
					System.out.println("Back to Access Screen");
				} catch (Exception e) {
					showErrorScreen(e);
				}
			});
		}

		private void showErrorScreen(Exception error) {
			// hide other screens
			// TODO show error ui
			System.out.println("Error Screen");
			error.printStackTrace();
		}

	}

	public static void main(String args[]) {
		AtmUserInterface ui = new AtmUserInterface();
		ui.showLoginScreen();
	}
}