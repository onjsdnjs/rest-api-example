package example.api.control;

import example.api.dto.BoardDto;
import example.api.service.BoardService;
import example.common.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yookeun on 2017. 2. 26..
 */
@RestController
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ResultJson selectListBoard() {
        ResultJson resultJson = new ResultJson();
        List<BoardDto> list = boardService.selectListBoard();
        resultJson.setItems(list);
        resultJson.setTotal(list.size());
        return resultJson;
    }

    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public ResultJson selectOneBoard(@PathVariable("id") Integer id) {
        ResultJson resultJson = new ResultJson();
        resultJson.setObject(boardService.selectOneBoard(id));
        return resultJson;
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public ResultJson insertBoard(
            @RequestParam(value = "title", required = true) String title,
            @RequestParam(value = "content", required = true) String content){

        ResultJson resultJson = new ResultJson();
        resultJson.setResultCode(0); //성공
        return resultJson;
    }
}