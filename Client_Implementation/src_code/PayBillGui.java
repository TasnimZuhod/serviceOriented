package client.gui;
import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import client.payBill.PayBill;
import client.payBill.PayBillService;


public class PayBillGui {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PayBillGui window = new PayBillGui();
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
		shell.setSize(450, 476);
		shell.setText("Pay Bill service");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Area Code");
		label.setBounds(32, 29, 115, 25);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(228, 29, 173, 31);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(228, 102, 173, 31);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Telephone Number");
		label_1.setBounds(29, 105, 163, 25);
		
		Button btnPayBill = new Button(shell, SWT.NONE);
		btnPayBill.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String areaCode = text.getText();
		        String telNumber = text_1.getText();
		        String billNumber = text_2.getText();
		        String visaNumber = text_3.getText();
		        
		        PayBillService service4 = new PayBillService();
		        PayBill port4 = service4.getPayBillPort();
		        String result4 = port4.payBill(areaCode, telNumber, billNumber, visaNumber);
		        
		        JOptionPane.showMessageDialog(null, result4);
				
			}
		});
		btnPayBill.setText("Pay Bill");
		btnPayBill.setBounds(107, 351, 179, 35);
		
		Label lblBillNumber = new Label(shell, SWT.NONE);
		lblBillNumber.setText("Bill Number");
		lblBillNumber.setBounds(35, 192, 115, 25);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(231, 192, 173, 31);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(231, 265, 173, 31);
		
		Label lblN = new Label(shell, SWT.NONE);
		lblN.setText("Visa Number");
		lblN.setBounds(32, 268, 163, 25);

	}

}
