package edu.autocar.start.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.broker.MjpegBroker;

@Controller
public class CameraController {
	@GetMapping("/monitor")
	public void monitor() {
		
	}
	@GetMapping("/camera")
	public void camera() {
		
	}
	
	@Autowired
	MjpegBroker broker;
	
	@GetMapping("/camera/{cameraId}")
	public String camera(@PathVariable("cameraId") int cameraId, Model model) {
		model.addAttribute("deviceId", cameraId); 
		return "camera";
	}
	
	// 카메라의 이미지를 네트워크로 전송(MultipartFile)
	@PostMapping("/camera/{cameraId}")
	@ResponseBody
	public boolean postCamera(@PathVariable("cameraId") int cameraId,
							@RequestParam("image") MultipartFile image) {
		
		try {
			broker.update(cameraId, image.getBytes());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}		
		
	}
	
	
	
}
