package net.geeklythings.fieldmarshal.ui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

public class NewTournamentDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	protected Object result;
	protected Shell shlCreateNewTournament;
	private Text text;
	private Text textFormatSummary;
	private String clockFormat = null;
	private String eventFormat = null;
	private int numRounds;
	private String eventFormatString = null;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public NewTournamentDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlCreateNewTournament.open();
		shlCreateNewTournament.layout();
		Display display = getParent().getDisplay();
		while (!shlCreateNewTournament.isDisposed()) {
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
		shlCreateNewTournament = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		shlCreateNewTournament.setSize(389, 453);
		shlCreateNewTournament.setText("Create New Tournament");
		
		Button btnok = new Button(shlCreateNewTournament, SWT.NONE);
		btnok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO: send a new tournament object back to the parent 
				//int numRounds = 
				//Tournament tournmanet = new Tournament();
			}
		});
		btnok.setBounds(48, 365, 75, 25);
		btnok.setText("&OK");
		
		Button btncancel = new Button(shlCreateNewTournament, SWT.NONE);
		btncancel.setBounds(261, 365, 75, 25);
		btncancel.setText("&Cancel");
		
		Label lblNumberOfRounds = new Label(shlCreateNewTournament, SWT.NONE);
		lblNumberOfRounds.setBounds(48, 78, 130, 15);
		lblNumberOfRounds.setText("Number of Rounds");
		
		Combo comboNumRounds = new Combo(shlCreateNewTournament, SWT.NONE);
		comboNumRounds.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Combo box = (Combo)e.widget;
				numRounds = Integer.parseInt(box.getText());
				updateEventFormat();
			}
		});
		comboNumRounds.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		comboNumRounds.select(2);
		comboNumRounds.setBounds(216, 75, 91, 23);
		
		Label lblDate = new Label(shlCreateNewTournament, SWT.NONE);
		lblDate.setBounds(48, 285, 55, 15);
		lblDate.setText("Date");
		
		Label lblLocation = new Label(shlCreateNewTournament, SWT.NONE);
		lblLocation.setBounds(48, 320, 55, 15);
		lblLocation.setText("Location");
		
		DateTime dateTime = new DateTime(shlCreateNewTournament, SWT.BORDER);
		dateTime.setBounds(216, 276, 81, 24);
		
		text = new Text(shlCreateNewTournament, SWT.BORDER);
		text.setBounds(216, 317, 122, 21);
		
		Label lblTournamentFormat = new Label(shlCreateNewTournament, SWT.NONE);
		lblTournamentFormat.setBounds(48, 39, 130, 15);
		lblTournamentFormat.setText("Tournament Format");
		
		final Combo comboFormat = new Combo(shlCreateNewTournament, SWT.NONE);
		comboFormat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				eventFormat = comboFormat.getText();
			}
		});
		comboFormat.setItems(new String[] {"Steamroller", "Hardcore", "Iron Gauntlet", "Who's the Boss"});
		comboFormat.select(0);
		comboFormat.setBounds(215, 36, 122, 23);
		
		textFormatSummary = new Text(shlCreateNewTournament, SWT.BORDER | SWT.MULTI);
		textFormatSummary.setBounds(48, 173, 287, 81);
		
		Label lblClockFormat = new Label(shlCreateNewTournament, SWT.NONE);
		lblClockFormat.setBounds(48, 122, 91, 15);
		lblClockFormat.setText("Clock Format");
		
		Combo comboClockFormat = new Combo(shlCreateNewTournament, SWT.NONE);
		comboClockFormat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		comboClockFormat.setItems(new String[] {"Timed Turns", "Deathclock"});
		comboClockFormat.setBounds(216, 119, 91, 23);


	}
	private void updateEventFormat()
	{
		String format = null;
		clockFormat = comboClockFormat.
		format += numRounds;
		textFormatSummary.setText(format);
	}

}
