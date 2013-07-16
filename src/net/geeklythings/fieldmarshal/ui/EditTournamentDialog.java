package net.geeklythings.fieldmarshal.ui;

import net.geeklythings.fieldmarshal.data.Tournament;
import net.geeklythings.fieldmarshal.data.TournamentFactory;

import org.eclipse.swt.widgets.Composite;
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
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

public class EditTournamentDialog extends Dialog {
	private DataBindingContext m_bindingContext;

	protected Object result;
	protected Shell shlCreateNewTournament;
	private Text text;
	private Text textFormatSummary;
	private String clockFormat = null;
	private String eventFormat = null;
	private int numRounds = 0;
	private String eventFormatString = null;
	private Tournament tournament;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EditTournamentDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(Tournament tournament) {
		this.tournament = tournament;
		createContents();
		shlCreateNewTournament.open();
		shlCreateNewTournament.layout();
		Display display = getParent().getDisplay();
		while (!shlCreateNewTournament.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		//result = new Tournament(3);
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
				tournament = TournamentFactory.createTournament(numRounds);
				//collect all of the entries and update this tournament with the info
				//return the tournament somehow
				shlCreateNewTournament.close();
				System.out.println(e);				
				
			}
		});
		btnok.setBounds(48, 365, 75, 25);
		btnok.setText("&OK");
		
		Button btncancel = new Button(shlCreateNewTournament, SWT.NONE);
		btncancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlCreateNewTournament.close();
				System.out.println(e);
			}
		});
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
				tournament.getTournamentFormat().setNumRounds(numRounds);
				updateEventFormat();
				System.out.println(e);
				//System.out.println(e.data);
			}
		});
		comboNumRounds.setItems(new String[] {"1", "2", "3", "4", "5", "6", "7"});
		comboNumRounds.select(3);
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
		
		Combo comboFormat = new Combo(shlCreateNewTournament, SWT.NONE);
		comboFormat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Combo box = (Combo)e.widget;
				eventFormat = box.getText();
				System.out.println(eventFormat);
				System.out.println(e);
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
		
		final Combo comboClockFormat = new Combo(shlCreateNewTournament, SWT.NONE);
		comboClockFormat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Combo box = (Combo)e.widget;
				clockFormat = box.getText();
			}
		});
		comboClockFormat.setItems(new String[] {"Timed Turns", "Deathclock"});
		comboClockFormat.setBounds(216, 119, 91, 23);

		shlCreateNewTournament.addShellListener(new ShellAdapter() {
			
				@Override
				public void shellClosed(ShellEvent e)
				{
					
					e.getSource();
					EditTournamentDialog.this.updateTournamentOnClose(e);
				}
			
		});
			
	}
	
	
	public void updateTournamentOnClose(ShellEvent e){
		//do this on shell closing
		//update the tournament with all the stuff
		//tournament.
		/*clockFormat = this.shlCreateNewTournament.comboNumRounds.
		tournament.setDate(todaysDate);
		tournament.setLocation(loc);
		tournament.setOrganizer(organizer);
		tournament.setTournamentFormat(tournamentFormat);*/
		tournament.update();
		System.out.println(e);}
	
	private void updateEventFormat()
	{
		String format = null;
		//shlCreateNewTournament.
		//clockFormat = comboClockFormat.
		format += numRounds;
		textFormatSummary.setText(format);
		tournament.getTournamentFormat().setNumRounds(numRounds);
		//tournament.getTournamentFormat().setTournamentFormat(tournamentFormat)
		eventFormatString = format;
		//comboFormat
	}

}
