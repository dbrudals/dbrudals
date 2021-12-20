'''
Created on 2021. 7. 25.

@author: ykm09
'''
import discord
from discord.http import Route

bot = discord.Client()

default_components = [
    {
        "type": 1,
        "components": [
            {
                "type": 2,
                "label": "Python",
                "style": 2,
                "custom_id": "python",
                "emoji": {
                    "id": "847876880257908757",
                    "name": "python"
                }
            }, {
                "type": 2,
                "label": "Java",
                "style": 2,
                "custom_id": "java",
                "emoji": {
                    "id": "847876915619954708",
                    "name": "java"
                }
            }
        ]

    }
]
http = bot.http


@bot.event
async def on_ready():
    print("On Ready")


@bot.event
async def on_message(msg: discord.Message):
    if msg.content == "!프로그래밍":
        embed = discord.Embed(
            title="최고의 프로그래밍 언어",
            description="""Python: 0표
                Java: 0표""",
            colour=0x0080ff
        )

        response = await http.request(
            Route('POST', '/channels/{channel_id}/messages', channel_id=msg.channel.id), 
                json={"embed": embed.to_dict(), "components": default_components}
        )
        print(response)

@bot.event
async def on_socket_response(payload: dict):
    print(payload)
    if payload.get("t", "") == "INTERACTION_CREATE":
        d = payload.get("d", {})
        custom_id = d.get("data", {}).get("custom_id")

        interaction_id = d.get("id")
        interaction_token = d.get("token")
        await bot.http.request(
            Route("POST", f"/interactions/{interaction_id}/{interaction_token}/callback"),
            json={"type": 4, "data": {
                "content": "당신은 {}를 고르셨군요!".format(custom_id),
                "flags": 64
            }},
        )

bot.run('ODY2MTk3OTU2NDIyOTI2Mzc2.YPPDtQ.Wm1u0SZK3JG6_Z6G4dZnjEx6jMU')