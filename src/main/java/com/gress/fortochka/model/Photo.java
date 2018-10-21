package com.gress.fortochka.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Roman_Radetskiy.
 */
@Entity
@Table(name = "photo")
@Getter
@Setter
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="member_id", referencedColumnName="id")
    private Member member;

    public void setMember(Member member) {

        if (sameAsMember(member)){
            return;
        }
        Member oldMember = this.member;
        this.member = member;

        if (oldMember != null) {
            oldMember.removePhoto(this);
        }
        if (member != null) {
            member.addPhoto(this);
        }
    }

    private boolean sameAsMember(Member newMember) {
        return member == null ? newMember == null : member.equals(newMember);
    }
}