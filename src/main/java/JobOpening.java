import java.time.LocalDateTime;

public class JobOpening {

  private String mTitle;
  private String mDescription;
  private String mName;
  private String mEmail;
  private boolean mFilled;
  private LocalDateTime mCreatedAt;

  public JobOpening(String title, String description, String name, String email) {
    mTitle = title;
    mDescription = description;
    mName = name;
    mEmail = email;
    mFilled = false;
    mCreatedAt = LocalDateTime.now();
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

  public boolean isFilled() {
    return mFilled;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }
}
