package com.gress.fortochka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Roman_Radetskiy.
 */
@Entity
@Table(name = "kindergroup")
@Getter
@Setter
public class Kindergroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="kindergarten_id", referencedColumnName="id")
    private Kindergarten kindergarten;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "kindergroup", targetEntity=Member.class, cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        if (members.contains(member)) {
            return;
        }
        members.add(member);
        member.setKindergroup(this);
    }

    public void removeMember(Member member){
        members.remove(member);
        member.setKindergroup(null);
    }

    public void setKindergarten(Kindergarten kindergarten) {
        if (sameAsKindergarten(kindergarten)){
            return;
        }
        Kindergarten oldKindergarten = this.kindergarten;
        this.kindergarten = kindergarten;

        if (oldKindergarten != null) {
            oldKindergarten.removeKindergroup(this);
        }
        if (kindergarten != null) {
            kindergarten.addKindergroup(this);
        }

        this.kindergarten = kindergarten;
    }

    private boolean sameAsKindergarten(Kindergarten newKindergarten) {
        return kindergarten == null ? newKindergarten == null : kindergarten.equals(newKindergarten);
    }
}
