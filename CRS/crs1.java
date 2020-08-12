import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;	
import javax.swing.table.*;
//HOME PAGE
class Home extends JFrame implements ActionListener
{
	JLabel l,bg,h;
	JButton btn,can;
	public Home()
	{
		Font f = new Font("Time New Roman",Font.BOLD,25);
		h = new JLabel("CRS");
		l = new JLabel("<html><h1>This is our OOSD Project for the Course Registration System where Students can Login and Signup to choose a course and to view their profile and also the Faculties can also Login and Signup and apply for the online course teaching system.</h2></html>");
		btn = new JButton("ENTER");
		can = new JButton("CANCEL");
		h.setFont(f);
		ImageIcon imageIcon = new ImageIcon("home.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(1550, 800,  java.awt.Image.SCALE_SMOOTH);  
		imageIcon = new ImageIcon(newimg);
		JLabel bg = new JLabel(imageIcon);
		add(bg);
		bg.setLayout(null);
		h.setBounds(700,180,100,100);
		l.setBounds(250,250,1000,300);
		btn.setBounds(600,600,100,25);
		can.setBounds(800,600,100,25);
		btn.setBackground(Color.white);
		can.setBackground(Color.black);
		can.setForeground(Color.white);
		btn.addActionListener(this);
		can.addActionListener(this);
		bg.add(l);
		bg.add(h);
		bg.add(btn);
		bg.add(can);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent s)
	{
		if(s.getSource() == btn)
		{
			dispose();
			Start st = new Start();
		}
		else
		{
			dispose();
		}
	}
}


class Start extends JFrame implements ActionListener
{
	JLabel li,su;
	JButton b,c;
	public Start()
	{
		setTitle("Course Registration");
		ImageIcon stu = new ImageIcon("sin.jpg"); 
		ImageIcon tea = new ImageIcon("sup.jpg");
		Image image = stu.getImage();
		Image newimg = image.getScaledInstance(250,150,java.awt.Image.SCALE_SMOOTH);  
		stu = new ImageIcon(newimg); 
		Image image1 = tea.getImage();
		Image newimg1 = image1.getScaledInstance(250,150,java.awt.Image.SCALE_SMOOTH);  
		tea = new ImageIcon(newimg1); 
		b = new JButton(stu);
		c = new JButton(tea);
		setLayout(null);
		b.setBounds(664,250,250,150);
		c.setBounds(664,500,250,150);
		add(b);
		add(c);
		b.addActionListener(this);
		c.addActionListener(this);
		setExtendedState(MAXIMIZED_BOTH);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b)
		{
			dispose();
			SelectL l = new SelectL();
		}
		else
		{
			dispose();
			Select s = new Select();
		}
	}
}

//SIDE SELECTION PAGES
class Select extends JFrame implements ActionListener
{
	JButton b,c;
	JLabel l;
	public Select()
	{
		setTitle("SIDE SELECTION");
		Font f = new Font("Wide Latin",Font.BOLD,22);
		l = new JLabel("Select Your Side!!");
		l.setFont(f);
		ImageIcon stu = new ImageIcon("student.jpg"); 
		ImageIcon tea = new ImageIcon("teacher.jpg");
		Image image = stu.getImage();
		Image newimg = image.getScaledInstance(250,400,java.awt.Image.SCALE_SMOOTH);  
		stu = new ImageIcon(newimg); 
		Image image1 = tea.getImage();
		Image newimg1 = image1.getScaledInstance(250,150,java.awt.Image.SCALE_SMOOTH);  
		tea = new ImageIcon(newimg1); 
		b = new JButton(stu);
		c = new JButton(tea);
		setLayout(null);
		b.setBounds(664,250,250,150);
		c.setBounds(664,500,250,150);
		l.setBounds(604,50,1000,300);
		add(b);
		add(c);
		add(l);
		b.addActionListener(this);
		c.addActionListener(this);
		setExtendedState(MAXIMIZED_BOTH);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b)
		{
			dispose();
			Major m = new Major();
			
		}
		else
		{
			dispose();
			SignupF sf = new SignupF();
		}
	}
}

class SelectL extends JFrame implements ActionListener
{
	JButton b,c;
	JLabel l;
	public SelectL()
	{
		setTitle("SIDE SELECTION");
		Font f = new Font("Wide Latin",Font.BOLD,22);
		l = new JLabel("Select Your Side!!");
		l.setFont(f);
		ImageIcon stu = new ImageIcon("student.jpg"); 
		ImageIcon tea = new ImageIcon("teacher.jpg");
		Image image = stu.getImage();
		Image newimg = image.getScaledInstance(250,400,java.awt.Image.SCALE_SMOOTH);  
		stu = new ImageIcon(newimg); 
		Image image1 = tea.getImage();
		Image newimg1 = image1.getScaledInstance(250,150,java.awt.Image.SCALE_SMOOTH);  
		tea = new ImageIcon(newimg1); 
		b = new JButton(stu);
		c = new JButton(tea);
		setLayout(null);
		b.setBounds(664,250,250,150);
		c.setBounds(664,500,250,150);
		l.setBounds(604,50,1000,300);
		add(b);
		add(c);
		add(l);
		b.addActionListener(this);
		c.addActionListener(this);
		setExtendedState(MAXIMIZED_BOTH);
		Container c = getContentPane();
		c.setBackground(Color.white);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b)
		{
			dispose();
			LoginS ss = new LoginS();
		}
		else
		{
			dispose();
			LoginF sf = new LoginF();
		}
	}
}

//MAJOR SELECTION
class Major extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;
	JLabel l;
	public Major()
	{

			/*Icon co = new ImageIcon("c.jpg");
			Icon ee = new ImageIcon("e.jpg");
			Icon mec = new ImageIcon("c.jpg");
			Icon civ = new ImageIcon("e.jpg");*/
			b1 = new JButton("co");
			b2 = new JButton("ee");
			b3 = new JButton("mec");
			b4 = new JButton("civ");
			l = new JLabel("Select Your Major");
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			//setLayout(new BorderLayout());
			add(b1,BorderLayout.EAST);
			add(b2,BorderLayout.WEST);
			add(b3,BorderLayout.NORTH);
			add(b4,BorderLayout.SOUTH);
			add(l,BorderLayout.CENTER);
			setVisible(true);
			setSize(800,800);
	}

	public void actionPerformed(ActionEvent aee)
	{
		if(aee.getSource() == b1)
		{
			dispose();
			SignupCS s = new SignupCS("CSE");
		}
		else
		{
			dispose();
			SignupEEE ss  = new SignupEEE("ECE");
		}
	}
}

//SIGNUP PAGES
class SignupCS extends JFrame implements ActionListener
{
	JLabel namel,addrl,cityl,statel,nationl,passl,emaill,rerl;
    public JTextField namet,emailt,cityt,statet,nationt,passt;
    JButton b1,b2;
    JLabel l1,l2;
    String fpass,fname,femail,fcity,fstate,fnation,major;
    public SignupCS(String c)
    {
    	major=c;
    	 ImageIcon imageIcon = new ImageIcon("1.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(1550, 800,  java.awt.Image.SCALE_SMOOTH);  
		imageIcon = new ImageIcon(newimg);
		JLabel bg = new JLabel(imageIcon);
		add(bg);
        setTitle("Customer Details");
        namel = new JLabel("Name:");
        emaill = new JLabel("e-mail:");
        rerl = new JLabel();
        cityl = new JLabel("City:");
        passl = new JLabel("New Password:");
        statel = new JLabel("State:");
        l1 = new JLabel();
		l2 = new JLabel();
        nationl = new JLabel("Nationality:");
        namet = new JTextField();
        emailt = new JTextField();
        cityt = new JTextField();
        statet = new JTextField();
        nationt = new JTextField();
        passt = new JTextField();
        b1 = new JButton("Next");
        b2 = new JButton("Back");
        bg.add(namel);
        bg.add(namet);
        bg.add(emaill);
        bg.add(emailt);
        bg.add(passl);
        bg.add(passt);
        bg.add(cityl);
        bg.add(cityt);
        bg.add(statel);
        bg.add(statet);
        bg.add(nationl);
        bg.add(nationt);
        bg.add(b1);
        bg.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        bg.setLayout(new GridLayout(8,2));
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);

	}
		public void actionPerformed(ActionEvent e)
    {
    		fpass = passt.getText();
			fname = namet.getText();
			femail = emailt.getText();
			fcity = cityt.getText();
			fstate = statet.getText();
			fnation = nationt.getText();

    	if(e.getSource() == b1)
		{
			if(fpass.length() < 8)
			{
				JOptionPane.showMessageDialog(null, "Password is less than 8 characters!!");
			}
			else if(fpass == null && fname == null && femail == null && fcity == null && fstate == null && fnation == null)
			{
				l1.setText("Empty Fields present!!");
			}
			else
			{
				dispose();
				Ccourses c = new Ccourses(fname,fpass,femail,fcity,fstate,fnation,major);
			}
		}
		else
		{
			dispose();
			Home h = new Home();
		}
    }
}

class SignupEEE extends JFrame implements ActionListener
{
	JLabel namel,addrl,cityl,statel,nationl,passl,emaill,rerl;
    public JTextField namet,emailt,cityt,statet,nationt,passt;
    JButton b1,b2;
    JLabel l1,l2;
    String fpass,fname,femail,fcity,fstate,fnation,major;
    public SignupEEE(String c)
    {
    	major=c;
        setTitle("Customer Details");
        namel = new JLabel("Name:");
        emaill = new JLabel("e-mail:");
        rerl = new JLabel();
        cityl = new JLabel("City:");
        passl = new JLabel("New Password:");
        statel = new JLabel("State:");
        l1 = new JLabel();
		l2 = new JLabel();
        nationl = new JLabel("Nationality:");
        namet = new JTextField();
        emailt = new JTextField();
        cityt = new JTextField();
        statet = new JTextField();
        nationt = new JTextField();
        passt = new JTextField();
        b1 = new JButton("Next");
        b2 = new JButton("Back");
        add(namel);
        add(namet);
        add(emaill);
        add(emailt);
        add(passl);
        add(passt);
        add(cityl);
        add(cityt);
        add(statel);
        add(statet);
        add(nationl);
        add(nationt);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(new GridLayout(7,2));
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);

	}
		public void actionPerformed(ActionEvent e)
    {
    		fpass = passt.getText();
			fname = namet.getText();
			femail = emailt.getText();
			fcity = cityt.getText();
			fstate = statet.getText();
			fnation = nationt.getText();

    	if(e.getSource() == b1)
		{
			if(fpass.length() < 8)
			{
				JOptionPane.showMessageDialog(null, "Password is less than 8 characters!!");
			}
			else if(fpass == null || fpass == "" && fname == null || fname == "" && femail == null || femail == "" && fcity == null || fcity == "" && fstate == null || fstate == "" && fnation == null || fnation == "")
			{
				l1.setText("Empty Fields present!!");
			}
			else
			{
				dispose();
				EEEcourses c = new EEEcourses(fname,fpass,femail,fcity,fstate,fnation,major);
			}
		}
		else
		{
			dispose();
			Home h = new Home();
		}
    }
}

class SignupF extends JFrame implements ActionListener
{
	JLabel name,addr,city,state,nation,pass,email;
    JTextField namet,emailt,cityt,statet,nationt,passt;
    JButton b1,b2;
    JLabel l1,l2;
	Connection con;
	Statement st;
	ResultSet rs;
    public SignupF()
    {
        setTitle("Customer Details");
        name = new JLabel("Name:");
        email = new JLabel("e-mail:");
        city = new JLabel("City:");
        pass = new JLabel("New Password:");
        state = new JLabel("State:");
        l1 = new JLabel();
		l2 = new JLabel();
        nation = new JLabel("Nationality:");
        namet = new JTextField();
        emailt = new JTextField();
        cityt = new JTextField();
        statet = new JTextField();
        nationt = new JTextField();
        passt = new JTextField();
        b1 = new JButton("Next");
        b2 = new JButton("Back");
        add(name);
        add(namet);
        add(email);
        add(emailt);
        add(pass);
        add(passt);
        add(city);
        add(cityt);
        add(state);
        add(statet);
        add(nation);
        add(nationt);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(new GridLayout(7,2));
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
	}
		public void actionPerformed(ActionEvent e)
    {
		String name,email,city,state,nation,pass;
		pass = passt.getText();
		name = namet.getText();
		email = emailt.getText();
		city = cityt.getText();
		state = statet.getText();
		nation = nationt.getText();
    	if(e.getSource() == b1)
		{
			if(pass.length() < 8)
			{
				l1.setText("password must be of minimum 8 characters");
			}
			else
			{
				try 
				{
			
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
				st=con.createStatement();
				st.executeUpdate("insert into faculty(name,email,password,city,state,nation) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "')"); 
				con.close();
				}
				catch(Exception ex)
				{

				}
				dispose();
				LoginF lf = new LoginF();
			}
		}
		else
		{
			dispose();
			Home h = new Home();
		}
    }
}

//LOGIN PAGES
class LoginS extends JFrame implements ActionListener
{
	JLabel ud,pass,res;
	JTextField u;
	JPasswordField p;
	JButton b1,b2;
	Connection con;
	Statement st;
	ResultSet rs;
	int x=0;
	String us;

	public LoginS()
	{
		setTitle("LOGIN");
		ud = new JLabel("USER MAIL ID:");
		pass = new JLabel("PASSWORD:");
		u = new JTextField();
		p = new JPasswordField();
		u.setBackground(new Color(222, 222, 222));
		u.setForeground(Color.black);
		p.setBackground(new Color(222, 222, 222));
		p.setForeground(Color.black);
		b1 = new JButton("Login");
		b2 = new JButton("Cancel");
		res = new JLabel();
		ImageIcon imageIcon = new ImageIcon("signin.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(1550, 800,  java.awt.Image.SCALE_SMOOTH);  
		imageIcon = new ImageIcon(newimg);
		JLabel bg = new JLabel(imageIcon);
		ud.setBounds(950,450,300,30);
		u.setBounds(1050,450,300,30);
		pass.setBounds(950,500,100,30);
		p.setBounds(1050,500,300,30);
		b1.setBounds(1000,580,75,50);
		b2.setBounds(1100,580,75,50);
		bg.setLayout(null);
		add(bg);
		bg.add(ud);
		bg.add(u);
		bg.add(pass);
		bg.add(p);
		bg.add(res);
		bg.add(b1);
		bg.add(b2);
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		b2.setBackground(new Color(13, 204, 222));
		b2.setForeground(Color.white);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ea1)
	{
		String pas;
		us = u.getText();
		pas = p.getText();
		if(ea1.getSource() == b1)
		{
			try 
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
				st=con.createStatement();
				rs = st.executeQuery("select email,password from student where email='" + us + "' and password='" + pas + "'");
				while(rs.next())
				{
				String ui = rs.getString(1);
				String pa = rs.getString(2);
				if((us.equals(ui) &&	 pas.equals(pa))== true)
				{
					dispose();
					Profiles m = new Profiles(us);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username or Password!!");

				}

				}
				}
				catch(Exception ex)
				{
				}
				
		}
		else
		{
			dispose();
			Home h = new Home();
		}
	}
}

class LoginF extends JFrame implements ActionListener
{
	JLabel ud,pass,res;
	JTextField u;
	JPasswordField p;
	JButton b1,b2;
	Connection con;
	Statement st;
	ResultSet rs;
	String us="";

	public LoginF()
	{
		setTitle("LOGIN");
		ud = new JLabel("USER MAIL ID:");
		pass = new JLabel("PASSWORD:");
		u = new JTextField();
		p = new JPasswordField();
		u.setBackground(new Color(222, 222, 222));
		u.setForeground(Color.black);
		p.setBackground(new Color(222, 222, 222));
		p.setForeground(Color.black);
		b1 = new JButton("Login");
		b2 = new JButton("Cancel");
		res = new JLabel();
		ImageIcon imageIcon = new ImageIcon("signinf.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(1550, 800,  java.awt.Image.SCALE_SMOOTH);  
		imageIcon = new ImageIcon(newimg);
		JLabel bg = new JLabel(imageIcon);
		ud.setBounds(950,450,300,30);
		u.setBounds(1050,450,300,30);
		pass.setBounds(950,500,100,30);
		p.setBounds(1050,500,300,30);
		b1.setBounds(1000,580,75,50);
		b2.setBounds(1100,580,75,50);
		bg.setLayout(null);
		add(bg);
		bg.add(ud);
		bg.add(u);
		bg.add(pass);
		bg.add(p);
		bg.add(res);
		bg.add(b1);
		bg.add(b2);
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		b2.setBackground(new Color(13, 204, 222));
		b2.setForeground(Color.white);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ea1)
	{
		String pas;
		us = u.getText();
		pas = p.getText();
		if(ea1.getSource() == b1)
		{
			try 
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
				st=con.createStatement();
				rs = st.executeQuery("select email,password from faculty where email='" + us + "' and password='" + pas + "'");
				while(rs.next())
				{
				String ui = rs.getString(1);
				String pa = rs.getString(2);
				if(us.equals(ui) ||	 pas.equals(pa))
				{
					dispose();
					Profilef pf = new Profilef(us);
					
				}	
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username or Password!!");
					
				}
				}	
				}
				
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		else
		{
			Home h = new Home();
			dispose();
		}
	}
}
//COURSE PAGES

class Ccourses implements ActionListener
{
	JButton a,b,c,d,e,f,n;
	JLabel r;
	Connection con;
	Statement st;
	ResultSet rs;
	String msg;
	JFrame j;
	String name,email,city,nation,pass,state,major,co="";
	public Ccourses(String nam,String p,String em,String ci,String s,String na,String m)
	{
		name = nam;
		pass = p;
		email = em;
		city = ci;
		state = s;
		nation = na;
		major = m; 
		j = new JFrame();
		j.setTitle("Select your Course");
		a = new JButton("Internet Of Things");
		b = new JButton("JAVA");
		c = new JButton("PYTHON");
		d = new JButton("R STUDIO");
		e = new JButton("CYBER SECURITY");
		f = new JButton("ARTIFICIAL INTELLIGENCE");
		n = new JButton("Next");
		r = new JLabel();
		j.setLayout(new GridLayout(4,3));
		j.add(a);
		j.add(b);
		j.add(c);
		j.add(d);
		j.add(e);
		j.add(f);
		j.add(r);
		j.add(n);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		n.addActionListener(this);
		j.setVisible(true);
		j.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public void actionPerformed(ActionEvent cs)
	{
	
		String msg="",m;
		m=major;
		if(cs.getSource() == a)
		{
		msg="iot";
		}
		if(cs.getSource() == b)
		{
		msg="ja";
		}
		if(cs.getSource() == c)
		{
		msg="py";
		}
		if(cs.getSource() == d)
		{
		msg="stu";
		}
		if(cs.getSource() == e)
		{
		msg="sec";
		}
		if(cs.getSource() == f)
		{
		msg="ai";
		}
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
			st=con.createStatement();
			if(msg=="iot")
			{
				co = a.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')"); 
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="ja")
			{
				co = b.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="py")
			{
				co = c.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="stu")
			{
				co = d.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="sec")
			{
				co = e.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="ai")
			{
				co = f.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			}
			catch(Exception ex)
			{

			}
			 if(cs.getSource() == n)
			{
				Staffcs scs= new Staffcs(name,email,co);
				j.dispose();
			}
		}
	}


class EEEcourses implements ActionListener
{
	JButton a,b,c,d,e,f,n;
	JLabel r;
	Connection con;
	Statement st;
	ResultSet rs;
	JFrame j;
	public String name,email,city,state,nation,pass,major,co="";
	public EEEcourses(String nam,String p,String em,String ci,String s,String na,String m)
	{
		name = nam;
		pass = p;
		email = em;
		city = ci;
		state = s;
		nation = na;
		major = m; 
		j = new JFrame();
		j.setTitle("Select your Course");
		a = new JButton("ARDUINO");
		b = new JButton("RASBERRYPI");
		c = new JButton("EXTERNAL CIRCUITS");
		d = new JButton("CHIP PROCESSOR");
		e = new JButton("DIGITAL CIRCUITS");
		f = new JButton("IC CODING");
		n = new JButton("Next");
		r = new JLabel();
		j.setLayout(new GridLayout(4,3));
		j.add(a);
		j.add(b);
		j.add(c);
		j.add(d);
		j.add(e);
		j.add(f);
		j.add(r);
		j.add(n);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		n.addActionListener(this);
		j.setVisible(true);
		j.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public void actionPerformed(ActionEvent cs)
	{
		String fd=cs.getActionCommand();
		String msg="";
		if(fd == "ARDUINO")
		{
		msg="ar";
		}
		if(fd == "RASBERRYPI")
		{
		msg="rp";
		}
		if(fd == "EXTERNAL CIRCUITS")
		{
		msg="ec";
		}
		if(fd == "CHIP PROCESSOR")
		{
		msg="cp";
		}
		if(fd == "DIGITAL CIRCUITS")
		{
		msg="dc";
		}
		if(fd == "IC CODING")
		{
		msg="ic";
		}
			String m=major;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
			st=con.createStatement();
			r.setText("Connected");
			
			if(msg=="ar")
			{
				co = a.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')"); 
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="rp")
			{
				co = b.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="ec")
			{
				co = c.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="cp")
			{
				co = d.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="dc")
			{
				co = e.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			else if(msg=="ic")
			{
				co = f.getText();
				st.executeUpdate("insert into student(name,email,password,city,state,nation,course,major) values('" + name + "','"  + email  + "','" + pass + "','" + city + "','" + state + "','" + nation + "','"+ co +"','"+ m +"')");
				con.close();
				r.setText("Inserted");
			}
			}
			catch(Exception ex)
			{

			}
			if(cs.getSource() == n)
			{
				Staffeee se= new Staffeee(name,email,co);
				j.dispose();
			}
		}

	}
//Staff Selection
class Staffcs extends JFrame implements ActionListener
{
	JButton a,b,c,d,e,x;
	JLabel a1,a2,a3,a4,bg;
	Connection con;
	Statement st;
	ResultSet rs;
	String sname,smail,scourse,fmail="",major="CSE";
	public Staffcs(String na,String em,String cou)
	{
		sname = na;
		smail = em;
		scourse = cou;
		setTitle("Staff Selection");
		ImageIcon bgc = new ImageIcon("f.jpg");
		Image image = bgc.getImage();
		Image newimg = image.getScaledInstance(1500, 1500,  java.awt.Image.SCALE_SMOOTH);  
		bgc = new ImageIcon(newimg);
		ImageIcon f1 = new ImageIcon("fm.jpg");
		Image image1 = f1.getImage();
		Image newimg1 = image1.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);  
		f1 = new ImageIcon(newimg1);
		ImageIcon f2 = new ImageIcon("ff.jpg");
		Image image2 = f2.getImage();
		Image newimg2 = image2.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);  
		f2 = new ImageIcon(newimg2);
		ImageIcon f3 = new ImageIcon("fm.jpg");
		Image image3 = f3.getImage();
		Image newimg3 = image3.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);  
		f3 = new ImageIcon(newimg3);
		ImageIcon f4 = new ImageIcon("ff.jpg");
		Image image4 = f4.getImage();
		Image newimg4 = image4.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);  
		f4 = new ImageIcon(newimg4);
		a1 = new JLabel("Mr.Gunasekaran");
		a2 = new JLabel("Mrs.Anu");
		a3 = new JLabel("Mr.Balakumaran");
		a4 = new JLabel("Mrs.Stella");
		bg = new JLabel(bgc);
		a=new JButton(f1);
		b=new JButton(f2);
		c=new JButton(f3);
		d=new JButton(f4);
		e=new JButton("Next");
		x= new JButton("Cancel");
		add(bg);
		bg.setLayout(null);
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);
		bg.add(e);
		bg.add(x);
		bg.add(a1);
		bg.add(a2);
		bg.add(a3);
		bg.add(a4);
		
		a.setBounds(450,80,150,150);
		a1.setBounds(450,60,500,10);
		b.setBounds(250,80,150,150);
		a2.setBounds(250,60,500,10);
		c.setBounds(850,80,150,150);
		a3.setBounds(850,60,500,10);
		d.setBounds(650,80,150,150);
		a4.setBounds(650,60,500,10);
		e.setBounds(420,600,120,75);
		x.setBounds(700,600,120,75);

		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		x.addActionListener(this);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
	}

	public void actionPerformed(ActionEvent scs)
	{

		String fd ="";
		String fname="";
		if(scs.getSource() == a)
		{
			fd = "f1";
		}
		if(scs.getSource() == b)
		{
			fd = "f2";
		}
		if(scs.getSource() == c)
		{
			fd = "f3";
		}
		if(scs.getSource() == d)
		{
			fd = "f4";
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
			st=con.createStatement();
		if(fd == "f1")
		{
			fname = a1.getText();
			fmail="gunasekar.cse@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
		}
		else if(fd == "f2")
		{
			fname = a2.getText();
			fmail="anu1283.cs@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
			
		}
		else if(fd == "f3")
		{
			fname = a3.getText();
			fmail="balacse.cse@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
		}
		else if(fd == "f4")
		{
			fname = a4.getText();
			fmail = "stellamary@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
		}
	}
	catch(Exception e)
	{	
	}
	if(scs.getSource() == e)
	{
		dispose();
		LoginS ls= new LoginS();
	}
	else if (scs.getSource() == x)
	{
		Home h = new Home();
		dispose();
	}
	}
}

class Staffeee extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	JButton a,b,c,d,e,x;
	JLabel a1,a2,a3,a4,bg,t;
	String sname,smail,scourse,fmail="",major="EEE";
	public Staffeee(String na,String em,String cou)
	{
		sname = na;
		smail = em;
		scourse = cou;
		setTitle("Staff Selection"); 
		ImageIcon bgc = new ImageIcon("f.jpg");
		Image image = bgc.getImage();
		Image newimg = image.getScaledInstance(1500, 1500,  java.awt.Image.SCALE_SMOOTH);  
		bgc = new ImageIcon(newimg);
		ImageIcon f1 = new ImageIcon("fm.jpg");
		Image image1 = f1.getImage();
		Image newimg1 = image1.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);  
		f1 = new ImageIcon(newimg1);
		ImageIcon f2 = new ImageIcon("ff.jpg");
		Image image2 = f2.getImage();
		Image newimg2 = image2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);  
		f2 = new ImageIcon(newimg2);
		ImageIcon f3 = new ImageIcon("fm.jpg");
		Image image3 = f3.getImage();
		Image newimg3 = image3.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);  
		f3 = new ImageIcon(newimg3);
		ImageIcon f4 = new ImageIcon("ff.jpg");
		Image image4 = f4.getImage();
		Image newimg4 = image4.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);  
		f4 = new ImageIcon(newimg4);
		a1 = new JLabel("Mr.Arun Kumar");
		a2 = new JLabel("Mrs.Bala Dharshini");
		a3 = new JLabel("Mr.Chandran");
		a4 = new JLabel("Mrs.Fathima");
		bg = new JLabel(bgc);
		t = new JLabel();
		add(bg);
		bg.setLayout(null);
		a=new JButton(f1);
		b=new JButton(f2);
		c=new JButton(f3);
		d=new JButton(f4);
		e=new JButton("Next");
		x = new JButton("Cancel");
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);
		bg.add(e);
		bg.add(a1);
		bg.add(a2);
		bg.add(a3);
		bg.add(a4);
		bg.add(x);
		bg.add(t);
		t.setBounds(0,50,300,15);
		a.setBounds(450,80,150,150);
		a1.setBounds(450,60,500,10);
		b.setBounds(250,80,150,150);
		a2.setBounds(250,60,500,10);
		c.setBounds(850,80,150,150);
		a3.setBounds(850,60,500,10);
		d.setBounds(650,80,150,150);
		a4.setBounds(650,60,500,10);
		e.setBounds(420,600,120,75);
		x.setBounds(700,600,120,75);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		x.addActionListener(this);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
	}

	public void actionPerformed(ActionEvent scs)
	{

		String fd ="";
		String fname="";
		if(scs.getSource() == a)
		{
			fd = "f1";
		}
		if(scs.getSource() == b)
		{
			fd = "f2";
		}
		if(scs.getSource() == c)
		{
			fd = "f3";
		}
		if(scs.getSource() == d)
		{
			fd = "f4";
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
			st=con.createStatement();
			//t.setText(scourse);
		if(fd == "f1")
		{
			fname = a1.getText();
			fmail = "arunkumar.eee@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
		}
		else if(fd == "f2")
		{
			fname = a2.getText();
			fmail = "baladharshini@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
			
		}
		else if(fd == "f3")
		{
			fname = a3.getText();
			fmail = "chandran.eee@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
		}
		else if(fd == "f4")
		{
			fname = a4.getText();
			fmail = "fathima@kongu.edu";
			st.executeUpdate("insert into assign(student_name,student_mail,course,faculty_name,faculty_mail,major) values('" + sname + "','"  + smail  + "','"+ scourse +"','"+ fname +"','"+ fmail +"','"+ major +"')"); 
			con.close();
		}
	}
	catch(Exception e)
	{	
	}
	if(scs.getSource() == e)
	{
		dispose();
		LoginS ls= new LoginS();
	}
	else if (scs.getSource() == x)
	{
		dispose();
		Home h = new Home();
	}
	}
}
//PROFILE PAGES
class Profiles extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs1,rs2,rp;
	JLabel sname,smail,scity,sstate,snation,fname,fmail,scourse,smajor,bg;
	JLabel stname,stmail,stcity,ststate,stnation,stcourse,stmajor,ftname,ftmail;
	JButton r,q;
	String n,e,c,s,na,co,m,fn,fm,email;
	public Profiles(String ma)
	{
		Font f = new Font("Time New Roman",Font.BOLD,25);
		ImageIcon imageIcon = new ImageIcon("ps.jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(1500, 1500,  java.awt.Image.SCALE_SMOOTH);  
		imageIcon = new ImageIcon(newimg);
		JLabel bg = new JLabel(imageIcon);
		add(bg);
		bg.setLayout(new GridLayout(10,2));
		email = ma;
		sname = new JLabel("Name:");
		smail = new JLabel("Email:");
		scity = new JLabel("City:");
		sstate = new JLabel("State");
		snation = new JLabel("Nationality:");
		scourse = new JLabel("Course:");
		smajor = new JLabel("Major:");
		fname = new JLabel("Faculty Selected:");
		fmail = new JLabel("Faculty Mail ID:");
		stname = new JLabel();
		stmail = new JLabel();
		stcity = new JLabel();
		ststate = new JLabel();
		stnation = new JLabel();
		stcourse = new JLabel();
		stmajor = new JLabel();
		ftname = new JLabel();
		ftmail = new JLabel();
		sname.setFont(f);
		smail.setFont(f);
		scity.setFont(f);
		sstate.setFont(f);
		snation.setFont(f);
		scourse.setFont(f);
		smajor.setFont(f);
		fname.setFont(f);
		fmail.setFont(f);
		stname.setFont(f);
		stmail.setFont(f);
		stcity.setFont(f);
		ststate.setFont(f);
		stnation.setFont(f);
		stcourse.setFont(f);
		stmajor.setFont(f);
		ftname.setFont(f);
		ftmail.setFont(f);
		sname.setForeground(Color.white);
		smail.setForeground(Color.white);
		scity.setForeground(Color.white);
		sstate.setForeground(Color.white);
		snation.setForeground(Color.white);
		scourse.setForeground(Color.white);
		smajor.setForeground(Color.white);
		fname.setForeground(Color.white);
		fmail.setForeground(Color.white);
		r = new JButton("Reset Password");
		q = new JButton("Quit");
		bg.add(sname);
		bg.add(stname);
		bg.add(smail);
		bg.add(stmail);
		bg.add(scity);
		bg.add(stcity);
		bg.add(sstate);
		bg.add(ststate);
		bg.add(snation);
		bg.add(stnation);
		bg.add(smajor);
		bg.add(stmajor);
		bg.add(scourse);
		bg.add(stcourse);
		bg.add(fname);
		bg.add(ftname);
		bg.add(fmail);
		bg.add(ftmail);
		bg.add(r);
		bg.add(q);
		r.setBackground(Color.white);
		q.setBackground(Color.black);
		q.setForeground(Color.white);
		r.addActionListener(this);
		q.addActionListener(this);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
		st=con.createStatement();
		rs1=st.executeQuery("select * from student where email ='"+email+"'");
		while(rs1.next())
			{
				n=rs1.getString("name");
				e=rs1.getString("email");
				c=rs1.getString("city");
				s=rs1.getString("state");
				na=rs1.getString("nation");
				co=rs1.getString("course");
				m=rs1.getString("major");
			} 
		rs2=st.executeQuery("select * from assign where student_mail ='"+email+"'");
		while(rs2.next())
		{
			fn=rs2.getString("faculty_name");
			fm=rs2.getString("faculty_mail");

		}
		}
		catch(Exception exc)
		{
		}
		stname.setText(n);
		stmail.setText(e);
		stcity.setText(c);
		ststate.setText(s);
		stnation.setText(na);
		stcourse.setText(co);
		stmajor.setText(m);
		ftname.setText(fn);
		ftmail.setText(fm);
	}

	public void actionPerformed(ActionEvent rq)
	{
		if(rq.getSource() == r)
		{
			String str1 = JOptionPane.showInputDialog("Enter New Password(Password must be minimum 8 characters)");
			if(str1.length() < 8)
			{
				JOptionPane.showMessageDialog(null, "Password is less than 8 characters!!");
			}
			else
			{
				try
				{
					st.executeUpdate("update student set password = '"+ str1 +"' where email = '"+ email +"'");
					JOptionPane.showMessageDialog(null, "Password has been Reset Succesfully!!");
					dispose();
					LoginS ls = new LoginS();

				}
				catch(Exception exc)
				{
				}
			}

		}
		else if(rq.getSource() == q)
		{
			dispose();
			Home h = new Home();
		}
	}
}

class Profilef extends JFrame implements ActionListener 
{
	String course,major,sname,smail,email;
	DefaultTableModel tbm;
	JTable tb;
	Connection con;
	Statement st;
	ResultSet rs;
	JButton b;

	public Profilef(String m)
	{
		email = m;
		tbm=new DefaultTableModel();
		tb=new JTable();
 		tb.setModel(tbm);
 		b= new JButton("Back");
 		b.addActionListener(this);
 		setLayout(new GridLayout(2,1));
		tbm.addColumn("Student-Name");
		tbm.addColumn("Student-eMail");
		tbm.addColumn("Course");
		tbm.addColumn("Major");
		add(tb);
		add(b);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crs","root","");
		st=con.createStatement();
		rs=st.executeQuery("select * from assign where faculty_mail ='"+email+"'");
		while(rs.next())
		{
			sname = rs.getString("student_name");
			smail = rs.getString("student_mail");
			course = rs.getString("course");
			major = rs.getString("major");
			tbm.addRow(new Object[]{sname,smail,course,major});
 		}
 		con.close();
	}
	catch(Exception exc)
	{
	}
}
	public void actionPerformed(ActionEvent ba)
	{
		dispose();
		Home h = new Home();
	}
}
//MAIN PAGE
class Test
{
    public static void main(String arr[])
    {
        Home h = new Home();
    }
}