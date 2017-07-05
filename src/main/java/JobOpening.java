import java.util.*;
import java.time.LocalDateTime;

public class JobOpening {

  private String mTitle;
  private String mDescription;
  private String mName;
  private String mEmail;
  private boolean mFilled;
  private LocalDateTime mCreatedAt;
  private static List<JobOpening> instances = new ArrayList<JobOpening>();
  private int mId;

  public JobOpening(String title, String description, String name, String email) {
    mTitle = title;
    mDescription = description;
    mName = name;
    mEmail = email;
    mFilled = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
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

  public static List<JobOpening> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static JobOpening find(int id) {
    return instances.get(id-1);
  }
}
