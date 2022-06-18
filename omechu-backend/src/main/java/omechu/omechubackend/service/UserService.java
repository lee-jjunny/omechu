package omechu.omechubackend.service;

import lombok.RequiredArgsConstructor;
import omechu.omechubackend.entity.User;
import omechu.omechubackend.entity.RoleType;
import omechu.omechubackend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    /**
     * 회원 가입
     */
    @Transactional
    public User saveUser(User user) {

        System.out.println("체크체크");
        validateDuplicateUser(user);

        System.out.println("체크체크체크");
        user.setRole(RoleType.ROLE_USER); // USER로 DEFAULT
        return userRepository.save(user);
    }

    /**
     * 중복 회원 검증
     */
    private void validateDuplicateUser(User user) {
        // 예외 처리
        List<User> findUser = userRepository.findByUsername(user.getUsername());
        if( !findUser.isEmpty() ) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 특정 회원 조회
     */
    public User findUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Transactional
    public User updateUser(Long id, User user) {

        User findUser = userRepository.findById(id).
                orElseThrow(
                        ()->new IllegalArgumentException("id를 확인해주세요")
                );

        findUser.setUsername(user.getUsername());
        return findUser;
    }
}
