package myspring.todo.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@RedisHash("Todo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = { "createTime", "title" })
@Builder
public class TodoVO {
	@Id
	private String createTime;
	private String title;
	private String contents;
	private String deadline;
}