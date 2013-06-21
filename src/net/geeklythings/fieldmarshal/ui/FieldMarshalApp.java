package net.geeklythings.fieldmarshal.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class FieldMarshalApp {

	protected Shell shlFieldMarshalTournament;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FieldMarshalApp window = new FieldMarshalApp();
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
		shlFieldMarshalTournament.open();
		shlFieldMarshalTournament.layout();
		while (!shlFieldMarshalTournament.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFieldMarshalTournament = new Shell();
		shlFieldMarshalTournament.setSize(617, 464);
		shlFieldMarshalTournament.setText("Field Marshal Tournament Organizer");
		
		Button btnEditPlayer = formToolkit.createButton(shlFieldMarshalTournament, "Edit Player", SWT.NONE);
		btnEditPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				PlayerEditor editPlayer = new PlayerEditor(shlFieldMarshalTournament, SWT.APPLICATION_MODAL);
				
			}
		});
		btnEditPlayer.setBounds(28, 27, 75, 25);

	}
}
