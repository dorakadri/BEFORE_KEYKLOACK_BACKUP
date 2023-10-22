const expressAsyncHandler = require("express-async-handler");
const puppeteer = require("puppeteer");


async function YTSearch(course) {
    const browser = await puppeteer.launch({
      headless: true,
      args: [
          "--no-sandbox",
          "--disable-gpu",
      ]
    });
    const page = await browser.newPage();
    await page.goto(
      `https://www.youtube.com/results?search_query=${course}`
    );
    await page.waitForSelector("div#contents");
    await page.waitForTimeout(10000);
  
    const titles = await page.evaluate(function () {
      return Array.from(
        document.querySelectorAll("ytd-video-renderer a#video-title")
      ).map((el) => ({
        title: el.getAttribute("title"),
        link: "https://www.youtube.com" + el.getAttribute("href"),
      }));
    });

    await browser.close();
    return JSON.stringify(titles);

  } 


  const coursefetching = expressAsyncHandler(async (req, res) => {
    const { course } = req.params;

    YTSearch(course)
      .then(result => {
        const crafts = JSON.parse(result);
        res.json(crafts);
      })
      .catch(err =>res.json(err));
  });
  
  module.exports = {

    coursefetching,
 
  };