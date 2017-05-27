package client.gui;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class MainGui {

	protected Shell shlMainGui;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainGui window = new MainGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMainGui.open();
		shlMainGui.layout();
		while (!shlMainGui.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMainGui = new Shell();
		shlMainGui.setSize(450, 428);
		shlMainGui.setText("Main Gui");
		
		Button btnCustomerData = new Button(shlMainGui, SWT.NONE);
		btnCustomerData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					CustomerDataGui window = new CustomerDataGui();
					window.open();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnCustomerData.setBounds(116, 44, 195, 35);
		btnCustomerData.setText("Customer Data");
		
		Button btnCustomerBills = new Button(shlMainGui, SWT.NONE);
		btnCustomerBills.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					PayBillGui window = new PayBillGui();
					window.open();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnCustomerBills.setText("Pay Bill");
		btnCustomerBills.setBounds(116, 273, 195, 35);
		
		Button btnPayBill = new Button(shlMainGui, SWT.NONE);
		btnPayBill.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					CustomerBillsGui window = new CustomerBillsGui();
					window.open();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnPayBill.setText("Customer Bills");
		btnPayBill.setBounds(116, 159, 195, 35);

	}
}
