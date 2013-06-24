package net.geeklythings.fieldmarshal.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import net.geeklythings.fieldmarshal.data.*;

public class PlayerEditor extends Dialog {

	protected Object result;
	protected Shell shlEditPlayer;
	private Text textFirstName;
	private Text textLastName;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public PlayerEditor(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlEditPlayer.open();
		shlEditPlayer.layout();
		Display display = getParent().getDisplay();
		while (!shlEditPlayer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlEditPlayer = new Shell(getParent(), getStyle());
		shlEditPlayer.setSize(387, 262);
		shlEditPlayer.setText("Edit Player");
		
		Label lblFirstName = new Label(shlEditPlayer, SWT.NONE);
		lblFirstName.setBounds(40, 39, 82, 15);
		lblFirstName.setText("First Name:");
		
		Label lblLastName = new Label(shlEditPlayer, SWT.NONE);
		lblLastName.setBounds(40, 92, 82, 15);
		lblLastName.setText("Last Name:");
		
		Label lblFaction = new Label(shlEditPlayer, SWT.NONE);
		lblFaction.setBounds(42, 142, 55, 15);
		lblFaction.setText("Faction:");
		
		textFirstName = new Text(shlEditPlayer, SWT.BORDER);
		textFirstName.setBounds(194, 33, 76, 21);
		
		textLastName = new Text(shlEditPlayer, SWT.BORDER);
		textLastName.setText("");
		textLastName.setBounds(194, 86, 76, 21);
		
		Combo combo = new Combo(shlEditPlayer, SWT.NONE);
		combo.setItems(Faction.enumsToStringArray());
		combo.setBounds(193, 134, 91, 23);

	}
}
