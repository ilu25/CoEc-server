package com.umc.coec.domain.skilled;

import com.umc.coec.domain.BaseTimeEntity;
import com.umc.coec.domain.enums.Status;
import com.umc.coec.domain.sports.Sports;
import com.umc.coec.domain.user.User;
import com.umc.coec.dto.partner.PartnerPostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Skilled extends BaseTimeEntity  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sportsId")
    private Sports sports;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    private int year;
    private int month;

    @Comment("점수 0~10")
    @Column(nullable = false)
    private int skilled;

    @Comment("경력, 수상이력 등 종목 관련 자기소개")
    @Column(length = 1000)
    private String experience;

    public void update(PartnerPostRequestDto partnerPostRequestDto) {
        if (partnerPostRequestDto.getSkilled() >= 0)
            this.setSkilled(partnerPostRequestDto.getSkilled());
        this.setYear(partnerPostRequestDto.getYear());
        this.setMonth(partnerPostRequestDto.getMonth());
        this.setExperience(partnerPostRequestDto.getExperience());

        this.setStatus(partnerPostRequestDto.getStatus().equals("모집중") ? Status.ACTIVE : Status.INACTIVE);
    }
}
