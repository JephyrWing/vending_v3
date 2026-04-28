package service;

import state.DrinkDto;
import state.MemberDto;
import repository.MemberRepository;
import state.MemberInfoDto;
import utilities.Utilities;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;
    Utilities utilities = new Utilities();

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public int register(String userid, String password, String name, String tel, String cardnum) {
        MemberInfoDto dto = new MemberInfoDto(userid, password, name, tel, 0,  cardnum, 0);
        int result = repository.register(dto);
        return result;
    }

    @Override
    public int[] login(String userId, String pw) {
        int[] result = null;
        List<MemberDto> list = repository.login(userId, pw);
        if (!list.isEmpty()) {
            result = new int[]{list.get(0).getId(), list.get(0).getIsAdmin()};
        } else {
            result = new int[]{0, 0};
        }
        return result;
    }

    @Override
    public List<MemberDto> getAll() {
        List<MemberDto> result = repository.findAll();
        return result;
    }

    @Override
    public List<MemberDto> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public int update(int id, String password, String name, String tel, int balance, String card_num, int isadmin) {
        MemberInfoDto dto = getInfoById(id).get(0);
        if (!password.equals("변경 없음")) {
            dto.setPassword(password);
        }
        dto.setName(name);
        dto.setTel(tel);
        dto.setBalance(balance);
        if (!card_num.equals("변경 없음")) {
            dto.setPassword(card_num);
        }
        dto.setIsAdmin(isadmin);
        return repository.update(dto);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

    @Override
    public int charge(int memberId, int amount) {
        MemberDto dto = getById(memberId).get(0);
        dto.addBalance(amount);
        repository.charge(dto);
        return dto.getBalance();
    }

    @Override
    public boolean checkUserId(String user_id) {
        List<MemberDto> list = getAll();
        boolean result = true;
        for (MemberDto i : list) {
            if (i.getUserId().equals(user_id)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean checkPass(String pass, String passConfirm) {
        boolean result = true;
        if (!pass.equals(passConfirm)) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean checkTel(String tel) {
        boolean result = true;
        if (!tel.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$")) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean checkCard(String cardNum) {
        boolean result = true;
        if (cardNum.length() > 16) {
            result = false;
            System.out.println("숫자만 입력해주세요.");
        } else if (!utilities.Luhn_Validation(cardNum)) {
            System.out.println("카드 번호가 유효하지 않습니다.");
        }
        return result;
    }

    @Override
    public int[] getIds() {
        List<MemberDto> list = getAll();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getId();
        }
        return result;
    }

    @Override
    public List<MemberInfoDto> getInfoById(int id) {
        return repository.findInfoById(id);
    }
}
