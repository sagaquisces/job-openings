public class JobOpening {

  private String mTitle;
  private String mDescription;
  private String mName;
  private String mEmail;

  public JobOpening(String title, String description, String name, String email) {
    mTitle = title;
    mDescription = description;
    mName = name;
    mEmail = email;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getName() {
    return mName;
  }

  public String getEmail() {
    return mEmail;
  }
}
