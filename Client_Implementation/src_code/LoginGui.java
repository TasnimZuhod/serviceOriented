package client.gui;
import javax.swing.JOptionPane;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import client.login.Login;
import client.login.LoginService;


public class LoginGui extends ApplicationWindow {
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the application window.
	 */
	public LoginGui() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(247, 72, 173, 31);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(247, 145, 173, 31);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(247, 220, 173, 31);
		
		Label lblAreaCode = new Label(container, SWT.NONE);
		lblAreaCode.setBounds(51, 72, 115, 25);
		lblAreaCode.setText("Area Code");
		
		Label lblTelephoneNumber = new Label(container, SWT.NONE);
		lblTelephoneNumber.setBounds(48, 148, 163, 25);
		lblTelephoneNumber.setText("Telephone Number");
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setBounds(51, 223, 81, 25);
		lblPassword.setText("Password");
		
		Button btnLogin = new Button(container, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String areaCode = text.getText();
				String telNumber = text_1.getText();
				String password = text_2.getText();
				
		        LoginService service1  = new LoginService();
		        Login port1 = service1.getLoginPort();
		        boolean isLogged = port1.dmzLogin(areaCode, telNumber, password);
		        
		        if(!isLogged)
		        	JOptionPane.showMessageDialog(null, "Invalid Credentials");
		        else {
		        	try {
		    			MainGui window = new MainGui();
		    			Display.getCurrent().close();
		    			window.open();
		    			
		    		} catch (Exception ex) {
		    			ex.printStackTrace();
		    		}
		        }
		        
			}
		});
		btnLogin.setBounds(166, 363, 105, 35);
		btnLogin.setText("Login");

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			LoginGui loginWindow = new LoginGui();
			loginWindow.setBlockOnOpen(true);
			loginWindow.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Login Page");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(496, 603);
	}
}
