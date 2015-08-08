package ceoncall.domain;

@Entity
public class CaseNotes {
    @Id
    @GeneratedValue
    private Integer id;

    private String summary;
    private String description;

    private DateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}