package com.lambdaschool.apollo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contexts")
public class Context extends Auditable {

    /**
     * The primary key (long) of the contexts table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contextId;

    /**
     * The description (String). Cannot be null and must be unique
     */
    @NotNull
    @Column(nullable = false, unique = true)
    private String description;

    /**
     * A list of questions the context is asssociated with
     */
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
            })
    @JoinTable(name = "contextQuestions",
            joinColumns = { @JoinColumn(name = "contextid")},
            inverseJoinColumns = {@JoinColumn(name = "questionid")})
    @JsonIgnoreProperties(value = "contexts")
    private List<Question> contextquestions = new ArrayList<>();

    /**
     * One to One relationship between context and survey
     * context connects to survey that contains a list of default questions for current context
     */
    @OneToOne
    @JoinColumn(name = "surveyId")
    private Survey survey;

    /**
     * Default constructor used primarily by the JPA.
     */
    public Context() {
    }

    /**
     * Given the params, create a new context object
     * <p>
     * contextId is autogenerated
     *
     * @param description The description (String) of the context
     * @param survey      The survey (Survey) connected to the context
     */
    public Context(String description, Survey survey) {
        this.description = description;
        this.survey = survey;
    }

    /**
     * Getter for contextId
     *
     * @return the contextId (long) of the context
     */
    public long getContextId() {
        return contextId;
    }

    /**
     * Setter for contextId. Used primary for seeding data
     *
     * @param contextId the new contextId (long) of the context
     */
    public void setContextId(long contextId) {
        this.contextId = contextId;
    }

    /**
     * Getter for description
     *
     * @return the description (String) of the context
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for questionId. Used primary for seeding data
     *
     * @param description the new description (String) of the context
     */
    public void setDescription(String description) {
        this.description = description.toLowerCase();
    }

    /**
     * Getter for survey
     *
     * @return the survey (Survey) connected to the context
     */
    public Survey getSurvey() {
        return survey;
    }

    /**
     * Setter for questionId. Used primary for seeding data
     *
     * @param survey the new survey (Survey) connected to the context
     */
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }



}
