import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Screen extends JPanel implements ActionListener {
    private ArrayList<Contact> contacts;
	private List<Contact> displayedContacts;
    private JList contactsList;
    private JScrollPane contactsListPane;
    private JTextField searchField;
    private JButton searchByFirst;
	private JButton searchByLast;
	private JButton searchByUsername;
	private JButton searchByDomain;
	private JButton searchByTLD;
	private JButton exitSearch;
	private JButton sortByFirst;
	private JButton sortByLast;
	private JButton sortByEmail;

	public Screen() {
		this.setLayout(null);
		this.setFocusable(true);

		contacts = new ArrayList<Contact>(0);
        contacts.add(new Contact("John", "Doe", "mr10thbestperson@toottoot.com"));
		contacts.add(new Contact("Jane", "Doe", "mrs9thbestperson@toottoot.com"));
		contacts.add(new Contact("Adam", "Smith", "adamsmith@gmail.com"));
		contacts.add(new Contact("Victoria", "Jones", "vjones@rocketuni.edu"));
		contacts.add(new Contact("Clarence", "Whudja", "cwhudja@kars4kids.org"));
		contacts.add(new Contact("Robert", "Kramer", "robertkramer1977@yahoo.com"));
		contacts.add(new Contact("Eric", "Landa", "elanda@gmail.com"));
		contacts.add(new Contact("Ryan", "Balch", "ryanbalch1020@rocketmail.co"));
		contacts.add(new Contact("Erikka", "Maaanson", "erikkaisthebest@imsofullofmyself.io"));
		contacts.add(new Contact("Senator", "Jamm", "imakejammoutofyou@urface.net"));

		// At first, all contacts will be shown.
		displayedContacts = (ArrayList<Contact>)contacts.clone();

		int searchBtnsX = 440;

		searchField = new JTextField();
		searchField.setBounds(searchBtnsX, 50, 100, 30);
		add(searchField);

		searchByFirst = new JButton("Search by First Name");
		searchByFirst.setBounds(searchBtnsX, 90, 175, 30);
		searchByFirst.addActionListener(this);
		add(searchByFirst);

		searchByLast = new JButton("Search by Last Name");
		searchByLast.setBounds(searchBtnsX, 130, 175, 30);
		searchByLast.addActionListener(this);
		add(searchByLast);

		searchByUsername = new JButton("Search by Username");
		searchByUsername.setBounds(searchBtnsX, 170, 175, 30);
		searchByUsername.addActionListener(this);
		add(searchByUsername);

		searchByDomain = new JButton("Search by Domain");
		searchByDomain.setBounds(searchBtnsX, 210, 175, 30);
		searchByDomain.addActionListener(this);
		add(searchByDomain);

		searchByTLD = new JButton("Search by Domain TLD");
		searchByTLD.setBounds(searchBtnsX, 250, 175, 30);
		searchByTLD.addActionListener(this);
		add(searchByTLD);

		exitSearch = new JButton("Exit Search");
		exitSearch.setBounds(searchBtnsX, 290, 175, 30);
		exitSearch.addActionListener(this);
		// Only add this button if a search is in progress

		int sortBtnsX = 625;

		sortByFirst = new JButton("Sort by First Name");
		sortByFirst.setBounds(sortBtnsX, 90, 150, 30);
		sortByFirst.addActionListener(this);
		add(sortByFirst);

		sortByLast = new JButton("Sort by Last Name");
		sortByLast.setBounds(sortBtnsX, 130, 150, 30);
		sortByLast.addActionListener(this);
		add(sortByLast);

		sortByEmail = new JButton("Sort by Email");
		sortByEmail.setBounds(sortBtnsX, 170, 150, 30);
		sortByEmail.addActionListener(this);
		add(sortByEmail);

		contactsList = new JList(displayedContacts.toArray());
		contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contactsList.setLayoutOrientation(JList.VERTICAL);

		contactsListPane = new JScrollPane(contactsList);
		contactsListPane.setPreferredSize(new Dimension(400, 400));
		contactsListPane.setBounds(25, 25, 400, 500);
		add(contactsListPane);
	}

	//Sets the size of the panel
	public Dimension getPreferredSize() { return new Dimension(800,600); }
 
	public void paintComponent(Graphics g) { super.paintComponent(g); }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitSearch) {
			displayedContacts = (ArrayList<Contact>) contacts.clone();
			remove(exitSearch);
		} else if(e.getSource() == sortByFirst) {
			Collections.sort(displayedContacts, new Comparator<Contact>() {
				@Override
				public int compare(Contact o1, Contact o2) {
					return o1.getFirstName().compareTo(o2.getFirstName());
				}
			});
		} else if(e.getSource() == sortByLast) {
			Collections.sort(displayedContacts, new Comparator<Contact>() {
				@Override
				public int compare(Contact o1, Contact o2) {
					return o1.getLastName().compareTo(o2.getLastName());
				}
			});
		} else if(e.getSource() == sortByEmail) {
			Collections.sort(displayedContacts, new Comparator<Contact>() {
				@Override
				public int compare(Contact o1, Contact o2) {
					int uname = o1.getEmailUsername().compareTo(o2.getEmailUsername());
					if (uname != 0) return uname;
					else {
						int domain = o1.getEmailDomain().compareTo(o2.getEmailDomain());
						if (domain != 0) return domain;
						else return o1.getEmailTLD().compareTo(o2.getEmailTLD());
					}
				}
			});
		} else {
			displayedContacts.clear();

			for(int i = 0; i < contacts.size(); i++) {
				if(e.getSource() == searchByFirst) {
					if (contacts.get(i).getFirstName().toLowerCase().equals(searchField.getText().toLowerCase())) {
						displayedContacts.add(contacts.get(i));
					}
				} else if(e.getSource() == searchByLast) {
					if (contacts.get(i).getLastName().toLowerCase().equals(searchField.getText().toLowerCase())) {
						displayedContacts.add(contacts.get(i));
					}
				} else if(e.getSource() == searchByUsername) {
					if(contacts.get(i).getEmailUsername().toLowerCase().equals(searchField.getText().toLowerCase())) {
						displayedContacts.add(contacts.get(i));
					}
				} else if(e.getSource() == searchByDomain) {
					if(contacts.get(i).getEmailDomain().toLowerCase().equals(searchField.getText().toLowerCase())) {
						displayedContacts.add(contacts.get(i));
					}
				} else if(e.getSource() == searchByTLD) {
					if(contacts.get(i).getEmailTLD().toLowerCase().equals(searchField.getText().toLowerCase())) {
						displayedContacts.add(contacts.get(i));
					}
				}
			}

			add(exitSearch);
		}

		repaint();
		contactsList.setListData(displayedContacts.toArray());
	}
}
