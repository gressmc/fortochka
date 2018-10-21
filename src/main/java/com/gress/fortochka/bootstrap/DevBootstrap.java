package com.gress.fortochka.bootstrap;

import com.gress.fortochka.model.Member;
import com.gress.fortochka.model.Photo;
import com.gress.fortochka.repositories.MemberRepository;
import com.gress.fortochka.repositories.PhotoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * @author Roman_Radetskiy.
 */
@Component
@Slf4j
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    PhotoRepository photoRepository;
    MemberRepository memberRepository;

    public DevBootstrap(PhotoRepository photoRepository, MemberRepository memberRepository) {
        this.photoRepository = photoRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Photo photo = new Photo();
        Member member = new Member();
        member.setLastName("Duduka");
        photo.setCode("0002");
        photo.setUrl("Url2");

        member.addPhoto(photo);

        memberRepository.save(member);

        photoRepository.save(photo);

        Photo photo1 = photoRepository.findByCode("0002");
        Member member1 = photo1.getMember();
        log.info("Photo {}", photo.getMember().getLastName());
        log.info("Photo {}", member1.getLastName());
    }
}
