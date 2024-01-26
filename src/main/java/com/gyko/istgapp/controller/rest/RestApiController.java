package com.gyko.istgapp.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestApiController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    RestTemplateBuilder restTemplateBuilder;
	
	@PostMapping("/search")
	public String hello(@RequestParam(value = "hashtags", required = false) String hashtags)  {
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		
		log.debug("hashtags : " + hashtags);
		
		String result = restTemplate.getForObject("https://graph.facebook.com/v19.0/ig_hashtag_search?user_id=17841464529474233&q="+hashtags+"&access_token=EAAj8mZCMxNB8BO2ze3KpKSmQsBBSuMNy3Jr4CQS805B1DffdrXtb0hk16ddR8Y1WhfTfs3ZCWwZC4wRgOEthadeRbwg5IZANbV7m67hMccN7RyU64l9ZAwbjBCUZAxRGRkW7x8wyXxfsATuUNY1eFvpfeLSuAoaMLc2LMtZCavbAZBuQGoc3kfZAV17VCBsnYqhW30ZCzjYHpR2Kywxcw9HZAMrVZAN0YAZDZD", String.class);
		
		log.debug("result : " + result);
		
		
		return "Hello ";
	}
	
/*
	@RequestMapping("/login")
	public String hello(@RequestParam(value = "userName", required = false) String userName) throws UnknownHostException {
		
		if ( StringUtils.isEmpty(userName)) {
			userName = "누구?";
		}
		
		return "Hello " + userName + "!!! Connected IP :" + InetAddress.getLocalHost().getHostAddress();
	}
	
	@PostMapping("/fileupload")
    public String fileUpload(@ModelAttribute MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {
        
		log.info("start : " + file);
		log.info("start : " + file.getOriginalFilename());
		log.info("start : " + file.getOriginalFilename());
        
        
//        File converFile = new File(file.getOriginalFilename());
//
//        file.transferTo(converFile);
//        file.transferTo(new File(file.getOriginalFilename()));
        
        
        

        String filename_url = file.getOriginalFilename();
        String message = file.getOriginalFilename()+ " 파일이 저장되었습니다.";

        log.debug("test : " + filename_url + ", " + message);
        
        String result = "";
        
        try {
			result = awsS3Service.upload(file, file.getOriginalFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Exception!", e);
		}
        
        
        return result;
    }
	
	// 다운로드
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value = "image") String image) {
    
    //  ex. image=https://board-example.s3.ap-northeast-2.amazonaws.com/2b8359b2-de59-4765-8da0-51f5d4e556c3.jpg
    
        byte[] data = awsS3Util.downloadFile(image);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + image + "\"")
                .body(resource);
    }



    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(awsS3Util.deleteFile(fileName), HttpStatus.OK);
    }
    
*/    
}