package com.cos.photogramstart.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
					name= "subscribe_uk",
					columnNames = {"fromUserId", "toUserId"}    // 이걸로 한 유저가 다른 한 유저를 구독하는 건 유니크하다는 걸 추가해줌
			)
		}
)
public class Subscribe {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스에 맞게 따라간다.
	private int id;
	
	@JoinColumn(name= "fromUserId")
	@ManyToOne
	// 구독 하는 유저
	private User fromUser;
	
	@JoinColumn(name= "toUserId")
	@ManyToOne
	// 구독 받은 유저
	private User toUser;
	
	private LocalDateTime createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
