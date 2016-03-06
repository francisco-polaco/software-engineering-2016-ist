package pt.tecnico.myDrive.domain;

public class User extends User_Base {
    
    private static final String DEFAULT_UMASK = "rwxd----";


	public User() {
        super();
    }
    
    public User(String username)/* TODO: throws */ {
    	this.init(username, username, username, DEFAULT_UMASK);
    }
    

    
    protected void init(String username, String password, String name, String umask)/* TODO: throws */ {
    	/* The directory must be linked after the user creation */
    	if(username.equals("root")){
    		// TODO : throw exception
    	}
    	
    	this.setUsername(username);
    	this.setPassword(password);
    	this.setName(name);
    	this.setUmask(umask);
    }
    
    @Override
	public void setUsername(String username){
    	super.setUsername(username);
    }
    
    @Override
	public void setPassword(String password){
    	super.setPassword(password);
    }
    
    @Override
	public void setName(String name){
    	super.setName(name);
    }
    
    @Override
	public void setUmask(String umask){
    	super.setUmask(umask);
    }
    
    @Override 
    public void setHomeDirectory(Directory homeDirectory){
    	super.setHomeDirectory(homeDirectory);
    }
    
    /* Fenixframework binary relations setters */
    
    @Override
    public void setFilesystem(FileSystem fs) {
        if (fs == null)
            super.setFilesystem(null);
        else
            fs.addUsers(this);
    }
    
    @Override
    public void setMyDriveManager(MyDriveManager mngr) {
        if (mngr == null)
            super.setMyDriveManager(null);
        else
        	mngr.setCurrentUser(this);
    }
    
    @Override
    public void setFile(File file) {
        if (file == null)
            super.setFile(null);
        else
        	file.setOwner(this);
    }
    

    public void remove(){
    	this.setHomeDirectory(null);
    	deleteDomainObject();
    }
    
    
	public boolean isRoot() {
		return false;
	}
    
}