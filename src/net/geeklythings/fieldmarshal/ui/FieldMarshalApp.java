package net.geeklythings.fieldmarshal.ui;

import net.geeklythings.fieldmarshal.data.Tournament;
import net.geeklythings.fieldmarshal.sql.ConnectionFactory;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import java.sql.Connection;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

public class FieldMarshalApp {

	protected Shell shlFieldMarshalTournament;
	protected Tournament activeTournament;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			FieldMarshalApp window = new FieldMarshalApp();
			//window.loadDatabase();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadDatabase() throws Exception
	{
		//dbConnection = ConnectionFactory.createDBConnection();
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
		
		Menu menu = new Menu(shlFieldMarshalTournament, SWT.BAR);
		shlFieldMarshalTournament.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("&File");
		
		Menu menu_2 = new Menu(mntmFile);
		mntmFile.setMenu(menu_2);
		
		MenuItem mntmnewTournament = new MenuItem(menu_2, SWT.NONE);
		mntmnewTournament.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO: create a new tournament
				EditTournamentDialog ntd = new EditTournamentDialog(shlFieldMarshalTournament, SWT.PRIMARY_MODAL);
				activeTournament = (Tournament)ntd.open(activeTournament);
				//tournament = new Tournament(3);
				
			}
		});
		mntmnewTournament.setText("&New Tournament");
		
		MenuItem menuItemOpen = new MenuItem(menu_2, SWT.NONE);
		menuItemOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO: open an existing tournament
				//create an empty tournament, then open the tournament dialogue using that tournament

			}
		});
		menuItemOpen.setText("&Open Tournament");
		
		Button btnNewTournament = new Button(shlFieldMarshalTournament, SWT.NONE);
		btnNewTournament.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EditTournamentDialog ntd = new EditTournamentDialog(shlFieldMarshalTournament, SWT.PRIMARY_MODAL);
				activeTournament = new Tournament(0);
				ntd.open(activeTournament);
			}
		});
		btnNewTournament.setBounds(10, 10, 124, 31);
		btnNewTournament.setText("New Tournament");
		
		Button btnLoadTournament = new Button(shlFieldMarshalTournament, SWT.NONE);
		btnLoadTournament.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnLoadTournament.setToolTipText("Load Existing Tournament");
		btnLoadTournament.setText("Load Tournament");
		btnLoadTournament.setBounds(10, 62, 124, 31);

	}
}
