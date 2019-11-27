package com.cos.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;
import com.cos.crud.utils.Script;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository mRepo;

	@GetMapping("/board/list")
	public String boardList(Model model) {
		List<Board> boards = mRepo.findAll();
		model.addAttribute("boards", boards); // jsp파일, items="${boards}"로 넘어감

		return "/board/list";
	}

	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id, Model model) {
		Optional<Board> board = mRepo.findById(id);// Optional : null처리하는 클래스
		model.addAttribute("board", board.get());
		return "/board/detail";
	}

	@DeleteMapping("board/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		//session 있어야 합니다.원래는...
		mRepo.deleteById(id);
		return "redirect:/board/list";
	}

	@GetMapping("/board/writeForm")
	public String boardWriteForm(HttpSession session) {
		//인터셉터 처리 AOP
		User user = (User) session.getAttribute("user");
		if(user != null) {
			return "/board/writeForm";
		}else {
			
			return"/user/loginForm";
		}
	}

	@PostMapping("board/write") // 데이터가 없는곳에 데이터가 들어갈 때 post
	public @ResponseBody String boardWrite(Board board, HttpSession session) {// session 있는 이유 : 유저 아니면 못하도록
		User user = (User) session.getAttribute("user");
		if(user != null) {
			board.setUser(user);
			mRepo.save(board);
			return Script.href("/board/list");
		}else {
			return Script.href("/user/loginForm");
		}
	}

	@PostMapping("/board/update/{id}") // 데이터가 있는데 수정이 일어날때
	public @ResponseBody String boardUpdate(@PathVariable int id, Board board) {
		mRepo.save(board);
		return Script.href("/board/list");
		
	}

	@GetMapping("/board/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id, Model model) {
		//session 있어야 합니다.원래는...
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board", board.get());
		return "/board/updateForm";
	}

}
