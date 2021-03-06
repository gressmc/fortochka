package com.gress.fortochka.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman_Radetskiy.
 */
@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="kindergroup_id", referencedColumnName="id")
    private Kindergroup kindergroup;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "member", targetEntity=Photo.class, cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(Photo photo){
        if (photos.contains(photo)) {
            return;
        }
        photos.add(photo);
        photo.setMember(this);
    }

    public void removePhoto(Photo photo){
        photos.remove(photo);
        photo.setMember(null);
    }

    public void setKindergroup(Kindergroup kindergroup) {
        if (sameAsKindergroup(kindergroup)){
            return;
        }
        Kindergroup oldKindergroup = this.kindergroup;
        this.kindergroup = kindergroup;

        if (oldKindergroup != null) {
            oldKindergroup.removeMember(this);
        }
        if (kindergroup != null) {
            kindergroup.addMember(this);
        }

        this.kindergroup = kindergroup;
    }

    private boolean sameAsKindergroup(Kindergroup newKindergroup) {
        return kindergroup == null ? newKindergroup == null : kindergroup.equals(newKindergroup);
    }
}
