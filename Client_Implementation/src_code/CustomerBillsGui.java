package client.gui;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import client.customerBills.CustomerBills;
import client.customerBills.CustomerBillsDtl;
import client.customerBills.CustomerBillsService;


public class CustomerBillsGui {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CustomerBillsGui window = new CustomerBillsGui();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(491, 532);
		shell.setText("Customer Bills Service");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Area Code");
		label.setBounds(60, 48, 115, 25);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(256, 48, 173, 31);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(256, 121, 173, 31);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Telephone Number");
		label_1.setBounds(57, 124, 163, 25);
		
		Button btnGetCustomer = new Button(shell, SWT.NONE);
		
		btnGetCustomer.setBounds(98, 233, 257, 35);
		btnGetCustomer.setText("Get Customer Bills Service");
		
		final StyledText styledText = new StyledText(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		styledText.setBounds(10, 298, 449, 168);
		
		
		btnGetCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
		        CustomerBillsService service2 = new CustomerBillsService();
		        CustomerBills port2 = service2.getCustomerBillsPort();
		        String areaCode = text.getText();
		        String telNumber = text_1.getText();
		        List<CustomerBillsDtl> result2 = port2.getCustomerBillsDmz(areaCode, telNumber);
		       
		        String data = "";
		        for(Object obj:result2){
		        	data += obj+"\n";
		        }
	        	styledText.setText(data);
			}
		});
		

	}
}
