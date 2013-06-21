package net.geeklythings.fieldmarshal.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class PlayerEditor extends Dialog {

	protected Object result;
	protected Shell shlEditPlayer;

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
		shlEditPlayer.setSize(450, 300);
		shlEditPlayer.setText("Edit Player");
		
		Label lblPlayerEditor = new Label(shlEditPlayer, SWT.NONE);
		lblPlayerEditor.setBounds(10, 10, 55, 15);
		lblPlayerEditor.setText("Player Editor");

	}
}
