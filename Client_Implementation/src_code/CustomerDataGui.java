package client.gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import client.customerData.CustomerDataDtl;
import client.customerData.GetCustomerData;
import client.customerData.GetCustomerDataService;


public class CustomerDataGui {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CustomerDataGui window = new CustomerDataGui();
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
		shell.setSize(498, 539);
		shell.setText("Customer Data Service");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Area Code");
		label.setBounds(58, 52, 115, 25);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(270, 49, 173, 31);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(270, 125, 173, 31);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Telephone Number");
		label_1.setBounds(34, 128, 163, 25);
		
		final StyledText styledText = new StyledText(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		styledText.setBounds(10, 298, 449, 168);
		
		Button btnGetCustomerData = new Button(shell, SWT.NONE);
		btnGetCustomerData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GetCustomerDataService service3 = new GetCustomerDataService();
		        GetCustomerData port3 = service3.getGetCustomerDataPort();
		        String areaCode = text.getText();
		        String telNumber = text_1.getText();
		        CustomerDataDtl result3 = port3.getCustomerData(areaCode, telNumber);

	        	styledText.setText(result3.toString());
			}
		});
		btnGetCustomerData.setText("Get Customer Data Service");
		btnGetCustomerData.setBounds(99, 214, 257, 35);

	}

}
